/*
 * 
 * 创建日期：2010-4-23 上午10:14:43
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.menu;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jbob.core.menu.XmlMenuManager;

public class XmlMenuManagerImpl implements XmlMenuManager {

	private DocumentBuilderFactory documentBuilderFactory;

	private String menuDocumentFile = "/META-INF/menu/menu.xml";
	private String styleGrantMenuDocumentFile = "/META-INF/menu/menu-grant.xsl";
	private String styleLeftMenuDocumentFile = "/META-INF/menu/menu-left.xsl";
	private String stylePublicDocumentFile = "/META-INF/menu/menu-public.xsl";

	private Document lefMenuDocument = null;
	private Document publicDocument = null;
	private Document grantDocument = null;
	private Document menuDocument = null;
	private Set<String> publicMenuIds = new HashSet<String>();
	private Map<String, Set<String>> urlFunctionMap = new  ConcurrentHashMap<String, Set<String>>();
	public XmlMenuManagerImpl() {
		documentBuilderFactory = DocumentBuilderFactory.newInstance();

		menuDocument = createDocument(menuDocumentFile);

		grantDocument = createDocumentBuilder().newDocument();
		styleDocument(menuDocument, grantDocument, styleGrantMenuDocumentFile);

		lefMenuDocument = createDocumentBuilder().newDocument();
		styleDocument(menuDocument, lefMenuDocument, styleLeftMenuDocumentFile);

		publicDocument = createDocumentBuilder().newDocument();
		styleDocument(menuDocument, publicDocument, stylePublicDocumentFile);

		Element root = publicDocument.getDocumentElement();

		{
			NodeList list = root.getElementsByTagName("Items");
			int length = list.getLength();
			for (int i = 0; i < length; i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					publicMenuIds.add(e.getAttribute("id"));
				}
			}
		}

		{
			NodeList list = root.getElementsByTagName("Item");
			int length = list.getLength();
			for (int i = 0; i < length; i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					publicMenuIds.add(e.getAttribute("id"));
				}
			}
		}

	}

	public String asXMLChilds(Node parent) {
		StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r");
		builder.append("<Menus>\r");
		buildSubNodes(builder, parent);
		builder.append("\r</Menus>\r");
		return builder.toString();
	}

	private void buildSubNodes(StringBuilder builder, Node parent) {
		NodeList list = parent.getChildNodes();
		int length = list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				builder.append("<" + e.getNodeName());

				NamedNodeMap nodeMap = e.getAttributes();
				for (int j = 0; j < nodeMap.getLength(); j++) {
					Attr att = (Attr) nodeMap.item(j);
					builder.append(" ").append(att.getName()).append(" = \"").append(att.getValue()).append("\"");
				}
				builder.append(">");
				buildSubNodes(builder, node);
				builder.append("</" + e.getNodeName() + ">\r");
			}
		}
	}

	public Document getCurDocument(Set<String> rights) {
		if (rights.contains("__ALL")) {
			return lefMenuDocument;
		}
		Document menuDocument = createDocumentBuilder().newDocument();
		Element root = menuDocument.createElement("Menus");
		menuDocument.appendChild(root);
		buildSubMenus(menuDocument, lefMenuDocument.getDocumentElement(), root, rights);
		return menuDocument;
	}

	private void buildSubMenus(Document menuDocument, Element curNode, Node newCurNode, Set<String> rights) {
		NodeList list = curNode.getChildNodes();
		int length = list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				String id = e.getAttribute("id");
				if (publicMenuIds.contains(id) || rights.contains(id)) {
					Element newNode = menuDocument.createElement(e.getTagName());

					NamedNodeMap nodeMap = e.getAttributes();
					for (int j = 0; j < nodeMap.getLength(); j++) {
						Attr att = (Attr) nodeMap.item(j);
						Attr newAttr = menuDocument.createAttribute(att.getName());
						newAttr.setValue(att.getValue());
						newNode.setAttributeNode(newAttr);
					}
					//Node  newNode= curNode.cloneNode(false);
					newCurNode.appendChild(newNode);
					buildSubMenus(menuDocument, e, newNode, rights);
				}
			}
		}
	}

	public Set<String> getPublicIds() {
		return Collections.unmodifiableSet(publicMenuIds);
	}

	protected void styleDocument(Document document, Document documentResult, String stylesheet) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(getResourceAsStream(stylesheet)));
			DOMSource source = new DOMSource(document);
			DOMResult result = new DOMResult(documentResult);
			transformer.transform(source, result);
		} catch (TransformerException e) {
			System.err.println("couldn't get new document");
			throw new RuntimeException(e);
		}
	}

	protected DocumentBuilder createDocumentBuilder() {
		try {
			return documentBuilderFactory.newDocumentBuilder();
		} catch (Exception e) {
			System.err.println("couldn't get new document builder");
			throw new RuntimeException(e);
		}
	}

	protected Document createDocument(String fileName) {
		try {
			return createDocumentBuilder().parse(getResourceAsStream(fileName));
		} catch (Exception e) {
			System.err.println("couldn't get document");
			throw new RuntimeException(e);
		}
	}

	private InputStream getResourceAsStream(String fileName) {
		try {
			InputStream inputStream = getClass().getResourceAsStream(fileName);
			return inputStream;
		} catch (Exception e) {
			System.err.println("couldn't get Resource >>" + fileName);
			throw new RuntimeException(e);
		}
	}
	
	public Set<String> getFunctionIds(String url) {
		Set<String> functionIds = urlFunctionMap.get(url);
		if(null == functionIds){
			functionIds = new HashSet<String>();
			NodeList list = menuDocument.getElementsByTagName("url");
			int length = list.getLength();
			for (int i = 0; i < length; i++) {
				Element e = (Element) list.item(i);
				if(url.equals(e.getTextContent())){
					Element function =(Element)e.getParentNode();
					functionIds.add(function.getAttribute("id"));
				}
			}
			urlFunctionMap.put(url, functionIds);
		}
		return functionIds;
	}
	public static void main(String[] args) {
		XmlMenuManagerImpl xmlMenuManager = new XmlMenuManagerImpl();
		//System.out.println(xmlMenuManager.asXMLChilds(xmlMenuManager.getCurDocument(xmlMenuManager.getPublicIds()).getDocumentElement()));
		
		System.out.println(xmlMenuManager.getFunctionIds("/system/listAppUser.do"));
	}

}
