package com.jbob.system.ui;

import java.lang.reflect.Type;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jbob.core.Pageable;
import com.jbob.core.web.BaseJson;
import com.jbob.system.model.AppRole;
import com.jbob.system.service.AppRoleService;

@Controller()
@RequestMapping("/Role")
public class RoleController extends BaseJson {

	@Autowired
	private AppRoleService appRoleService;

	@RequestMapping(value = "/List")
	public String list(Model model) {
		Pageable<AppRole> pageable = appRoleService.getAll(0, 4);
		Type type = new TypeToken<Collection<AppRole>>(){}.getType();
		StringBuffer buff = new StringBuffer("{success:true,'totalCounts':").append(pageable.getLength()).append(",result:");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		buff.append(gson.toJson(pageable.getData(), type));
		buff.append("}");
		model.addAttribute("json", buff.toString());
		return JSON;
	}

}
