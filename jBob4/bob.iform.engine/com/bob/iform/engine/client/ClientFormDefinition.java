package com.bob.iform.engine.client;

import java.util.Map;

import com.bob.iform.engine.FormDefinition;
import com.bob.iform.fvm.FvmContext;

public interface ClientFormDefinition extends FormDefinition {

	ClientForm createForm(String key, FvmContext webUser,Map<String, Object> params);

	//ClientForm startForm();

	//ClientForm startForm(String key, WebUser webUser);
}
