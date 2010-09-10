package com.bob.iform.engine.field;

import java.io.Serializable;

import com.bob.iform.engine.Form;
import com.bob.iform.fvm.security.Permission;

/**
 * @author chenbing
 * 权限验证
 */
public interface PermissionBehaviour extends Serializable {

	Permission execute(Form form) throws Exception;
}
