/**
 * Created on 2010-5-4
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.Map;

import cn.blsoft.krport.action.Action;
import cn.blsoft.krport.dialect.Dialect;
import cn.blsoft.krport.htmlwidget.HtmlWidget;
import cn.blsoft.krport.initparam.Initparam;
import cn.blsoft.krport.returntype.ReturnType;

/**
 * <p>Title:  Config.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class Config {

	private  Map<String, Action> actions;
	
	private  Map<String, HtmlWidget> htmlWidgets;
	
	private  Map<String, ReturnType> returnTypes;	
	
	private  Map<String, Dialect> dialects;
	
	private  Map<String, Initparam> initparams;
	
	
	/**
	 * @return the actions
	 */
	public Map<String, Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(Map<String, Action> actions) {
		this.actions = actions;
	}

	/**
	 * @return the htmlWidgets
	 */
	public  Map<String, HtmlWidget> getHtmlWidgets() {
		return htmlWidgets;
	}

	/**
	 * @param htmlWidgets the htmlWidgets to set
	 */
	public  void setHtmlWidgets(Map<String, HtmlWidget> htmlWidgets) {
		this.htmlWidgets = htmlWidgets;
	}

	/**
	 * @return the returnTypes
	 */
	public  Map<String, ReturnType> getReturnTypes() {
		return returnTypes;
	}

	/**
	 * @param returnTypes the returnTypes to set
	 */
	public  void setReturnTypes(Map<String, ReturnType> returnTypes) {
		this.returnTypes = returnTypes;
	}
		

	/**
	 * @return the dialects
	 */
	public Map<String, Dialect> getDialects() {
		return dialects;
	}

	/**
	 * @param dialects the dialects to set
	 */
	public void setDialects(Map<String, Dialect> dialects) {
		this.dialects = dialects;
	}

	
	/**
	 * @return the initparams
	 */
	public Map<String, Initparam> getInitparams() {
		return initparams;
	}

	/**
	 * @param initparams the initparams to set
	 */
	public void setInitparams(Map<String, Initparam> initparams) {
		this.initparams = initparams;
	}

	public  Action getAction(String actionName){
		Action action = actions.get(actionName);
		if(null==action){
			action = actions.get("main");
		}
		return action;
	}
	
	public  HtmlWidget getHtmlWidget(String htmlWidgetName){
		HtmlWidget htmlWidget = htmlWidgets.get(htmlWidgetName);
		if(null==htmlWidget){
			htmlWidget = htmlWidgets.get("text");
		}
		return htmlWidget;
	}
	
	public  ReturnType getReturnType(String returnTypeName){
		ReturnType returnType = returnTypes.get(returnTypeName);
		if(null==returnType){
			returnType = returnTypes.get("void");
		}
		return returnType;
	}
	
	
	public  Dialect getDialect(String dialectName){
		Dialect dialect = dialects.get(dialectName);
		return dialect;
	}

	public  Initparam getInitparam(String initparamName){
		Initparam initparam = initparams.get(initparamName);
		return initparam;
	}
}
