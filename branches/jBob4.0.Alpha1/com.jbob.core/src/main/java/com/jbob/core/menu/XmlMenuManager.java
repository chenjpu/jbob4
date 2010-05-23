/*
 * 
 * 创建日期：2010-4-22 下午12:12:55
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.core.menu;

import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


public interface XmlMenuManager {
	Set<String> getPublicIds();
	Document getCurDocument(Set<String> rights);
	String asXMLChilds(Node parent);
	Set<String> getFunctionIds(String url);
}
