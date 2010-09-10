package com.bob.iform.engine.field;

import java.io.Serializable;

import com.bob.iform.engine.Form;

/** 
 * @author chenbing
 * 构建初始值
 */
public interface InitialValueBehaviour extends Serializable {

	String execute(Form form) throws Exception;
}
