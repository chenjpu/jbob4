/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bob.iform.engine.impl.html.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bob.iform.engine.FormException;
import com.bob.iform.engine.impl.HtmlFormDefinitionImpl;
import com.bob.iform.engine.impl.html.CompositeField;
import com.bob.iform.engine.impl.html.SubField;
import com.bob.iform.engine.impl.html.SubForm;
import com.bob.iform.engine.impl.util.xml.Attribute;
import com.bob.iform.engine.impl.util.xml.Element;
import com.bob.iform.engine.impl.util.xml.Parse;
import com.bob.iform.engine.impl.util.xml.Parser;
import com.bob.iform.fvm.impl.form.FieldImpl;
import com.bob.iform.fvm.impl.form.FormDefinitionImpl;
import com.bob.iform.fvm.impl.form.RoleDefinition;
import com.bob.iform.fvm.impl.form.ScopeImpl;
import com.bob.iform.fvm.security.Permission;

/**
 * @author Tom Baeyens
 * @author Joram Barrez
 */
public class FormParse extends Parse {

  public static final String PROPERTYNAME_ROLE_DECLARATION = "roleDeclarations";
  public static final String PROPERTYNAME_INITIAL = "initial";

  private static final Logger LOG = Logger.getLogger(FormParse.class.getName());
  
  /**
   * The end result of the parsing: a list of form definition.
   */
  private final List<FormDefinitionImpl> formDefinitions = new ArrayList<FormDefinitionImpl>();

  /**
   * Constructor to be called by the {@link FormParser}.
   * 
   * Note the package modifier here: only the {@link FormParser} is allowed to
   * create instances.
   */
  FormParse(Parser parser) {
    super(parser);
    setSchemaResource(FormParser.SCHEMA_RESOURCE);
  }

  @Override
  public FormParse execute() {
    try {
      super.execute(); // schema validation
    } catch (FormException e) {
      // Fall back to beta 1 XSD (see ACT-52)
      if (e.getMessage().toLowerCase().contains("cannot find the declaration of element 'definitions'")) {
        try {
          streamSource.getInputStream().reset();
          setSchemaResource(FormParser.BETA_SCHEMA_RESOURCE);
          super.execute();
        } catch (IOException ioe) {
          throw e;
        }
      } else {
        throw e;
      }
    }
    parseFormDefinitions(rootElement);
    return this;
  }

  
  /**
   * Parses all the form definitions defined within the 'definitions' root
   * element.
   * 
   * @param definitionsElement
   *          The root element of the XML file.
   */
  public void parseFormDefinitions(Element definitionsElement) {
    // TODO: parse specific definitions signalData (id, imports, etc)
    for (Element formElement : definitionsElement.elements("form")) {
      formDefinitions.add(parseForm(formElement));
    }
  }

  /**
   * Parses one form (ie anything inside a &lt;form&gt; element).
   * 
   * @param formElement
   *          The 'form' element.
   * @return The parsed version of the XML: a {@link FormDefinitionImpl}
   *         object.
   */
  public FormDefinitionImpl parseForm(Element formElement) {
	  FormDefinitionImpl formDefinition = new HtmlFormDefinitionImpl(formElement.attribute("id"));
    
	  formDefinition.setName(formElement.attribute("name"));
	  
	  String colspanString = formElement.attribute("colspan");
	  if(null != colspanString){
		  formDefinition.setColspan(Integer.parseInt(colspanString));
	  }
    if (LOG.isLoggable(Level.FINE)) {
      LOG.fine("Parsing form " + formDefinition.getName());
    }

    parseScope(formElement, formDefinition);
     
    return formDefinition;
  }
  
  /**
   * Parses a scope: a process, subprocess, etc.
   * 
   * Note that a process definition is a scope on itself.
   * 
   * @param scopeElement The XML element defining the scope
   * @param parentScope The scope that contains the nested scope. 
   */
  public void parseScope(Element scopeElement, ScopeImpl parentScope) {
    
    
    //parseStartEvents(scopeElement, parentScope);
    parseFields(scopeElement, parentScope);
    //parseEndEvents(scopeElement, parentScope);
    //parseBoundaryEvents(scopeElement, parentScope);
    //parseSequenceFlow(scopeElement, parentScope);
  }
  
  public void parseFields(Element parentElement, ScopeImpl scopeElement) {
    for (Element fieldElement : parentElement.elements()) {
      /*if (filedElement.getTagName().equals("text")) {
        parseText(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("hidden")) {
    	parseHidden(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("textfield")) {
        parseTextfield(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("textarea")) {
        parseTextarea(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("radio")) {
        parseRadio(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("select")) {
        parseSelect(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("subForm")) {
    	parseSubForm(filedElement, scopeElement);
      } else if (filedElement.getTagName().equals("compositeField")) {
    	parseCompositeField(filedElement, scopeElement);
      } */
    	
    	if(fieldElement.getTagName().equals("field")){
    		 FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
    		 parseScope(fieldElement, field);
    	}else if(fieldElement.getTagName().equals("subForm")){
    		FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
    		parseScope(fieldElement, field);
    	}else if(fieldElement.getTagName().equals("compositeField")){
    		FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
    		parseScope(fieldElement, field);
    	}
    	
    }
  }

  /**
   * Generic parsing method for most flow elements: parsing of the documentation
   * sub-element.
   */
  public String parseDocumentation(Element element) {
    Element docElement = element.element("documentation");
    if (docElement != null) {
      return docElement.getText().trim();
    }
    return null;
  }

  /**
   * Parses the generic information of an field element (id, name), and
   * creates a new {@link FieldImpl} on the given scope element.
   */
  public FieldImpl parseAndCreateFieldOnScopeElement(Element fieldElement, ScopeImpl scopeElement) {

    String id = fieldElement.attribute("id");
    //String name = fieldElement.attribute("name");
    if (LOG.isLoggable(Level.FINE)) {
      LOG.fine("Parsing field " + id);
    }
    FieldImpl field = scopeElement.createField(id);
    
    field.setName(fieldElement.attribute("name"));
    
    for (Attribute attribute : fieldElement.attributes()) {
    	 field.setProperty(attribute.getName(), attribute.getValue());
    }
    //field.setProperty("name", name);
    //field.setProperty("type", fieldElement.getTagName());
    field.setType(fieldElement.attribute("type"));
    field.setProperty("line", fieldElement.getLine());
    
    for (Element roleElement : fieldElement.elements("role")) {
    	addRoleDefinition(field,parseRoleDefinition(roleElement));
    }
    parseProperties(fieldElement, scopeElement);
    return field;
  }
  
  
  public void parseSubField(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new SubField());
  }

 
  /*public void parseText(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Text());
  }
  public void parseHidden(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Hidden());
  }
  public void parseTextfield(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Textfield());
  }
  public void parseTextarea(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Textarea());
  }
  public void parseRadio(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Radio());
  }
  public void parseSelect(Element fieldElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(fieldElement, scopeElement);
	  field.setFieldBehavior(new Select());
  }*/
  
  public void parseCompositeField(Element subFormElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(subFormElement, scopeElement);
	  field.setFieldBehavior(new CompositeField());
	  parseScope(subFormElement, field);
  }
  
  public void parseSubForm(Element subFormElement, ScopeImpl scopeElement) {
	  FieldImpl field = parseAndCreateFieldOnScopeElement(subFormElement, scopeElement);
	  field.setFieldBehavior(new SubForm());
	  parseScope(subFormElement, field);
  }

  /* userTask specific finals */
  public RoleDefinition parseRoleDefinition(Element roleElement) {
	  RoleDefinition roleDefinition = new RoleDefinition();

    String name = roleElement.attribute("name");
    if (name != null) {
    	roleDefinition.setName(name);
    }
    roleDefinition.setDescription(parseDocumentation(roleElement));
    
    String authority = roleElement.attribute("authority");
    
    if("NONE".equalsIgnoreCase(authority)){
    	roleDefinition.setPermission(Permission.NONE);
    }else if("READ".equalsIgnoreCase(authority)){
    	roleDefinition.setPermission(Permission.READ);
    }else if("WRITE".equalsIgnoreCase(authority)){
    	roleDefinition.setPermission(Permission.WRITE);
    }else {
    	roleDefinition.setPermission(Permission.ALL);
    }
    return roleDefinition;
  }

  protected void parseName(Element roleElement, RoleDefinition roleDefinition) {

  }

  
  public void parseProperties(Element element, ScopeImpl scopeElement) {
	    List<Element> propertyElements = element.elements("property");
	    for (Element propertyElement : propertyElements) {
	      parseProperty(propertyElement, scopeElement);
	    }
  }
  
  public void parseProperty(Element propertyElement, ScopeImpl scopeElement) {
	    scopeElement.property(propertyElement.getTagName(), propertyElement.getText());
 }

  @SuppressWarnings("unchecked")
protected void addRoleDefinition(ScopeImpl scope, RoleDefinition roleDefinition) {
    List<RoleDefinition> roleDeclarations = (List<RoleDefinition>) scope.getProperty(PROPERTYNAME_ROLE_DECLARATION);
    if (roleDeclarations==null) {
    	roleDeclarations = new ArrayList<RoleDefinition>();
    	scope.setProperty(PROPERTYNAME_ROLE_DECLARATION, roleDeclarations);
    }
    roleDeclarations.add(roleDefinition);
  }
  
  /* Getters, setters and Parser overriden operations */

  public List<FormDefinitionImpl> getFormDefinitions() {
    return formDefinitions;
  }

  public FormParse name(String name) {
    super.name(name);
    return this;
  }

  public FormParse sourceInputStream(InputStream inputStream) {
    super.sourceInputStream(inputStream);
    return this;
  }

  public FormParse sourceResource(String resource, ClassLoader classLoader) {
    super.sourceResource(resource, classLoader);
    return this;
  }

  public FormParse sourceResource(String resource) {
    super.sourceResource(resource);
    return this;
  }

  public FormParse sourceString(String string) {
    super.sourceString(string);
    return this;
  }

  public FormParse sourceUrl(String url) {
    super.sourceUrl(url);
    return this;
  }

  public FormParse sourceUrl(URL url) {
    super.sourceUrl(url);
    return this;
  }
}
