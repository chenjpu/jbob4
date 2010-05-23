/*
 * 
 * 创建日期：2010-4-21 下午05:30:48
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.jbob.core.menu.XmlMenuManager;
import com.jbob.core.web.BaseJson;
import com.jbob.security.util.SecurityContextUtil;
import com.jbob.system.model.AppUser;

@Controller()
@RequestMapping("/Menu")
public class MenuController extends BaseJson {
	@Autowired
	private XmlMenuManager menuManager;

	@RequestMapping(value = "/Left")
	public String Left(Model model) {
		AppUser currentUser = SecurityContextUtil.getCurrentUser();

		Document document = menuManager.getCurDocument(currentUser.getRights());
		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer("[");
		if (document != null) {
			Element root = document.getDocumentElement();
			NodeList list = root.getChildNodes();
			int length = list.getLength();
			for (int i = 0; i < length; i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					String id = e.getAttribute("id");
					String text = e.getAttribute("text");
					String iconCls = e.getAttribute("iconCls");
					sb.append("{id:'").append(id != null ? id : "").append("',");
					sb.append("text:'").append(text != null ? text : "").append("',");
					sb.append("iconCls:'").append(iconCls != null ? iconCls : "").append("',");
					sb.append("subXml:").append(gson.toJson(menuManager.asXMLChilds(e))).append("},");
				}
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		model.addAttribute("json", sb.toString());
		return JSON;
	}
}
