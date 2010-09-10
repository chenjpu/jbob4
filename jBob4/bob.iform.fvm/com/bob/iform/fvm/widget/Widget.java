package com.bob.iform.fvm.widget;

import java.io.Serializable;

import com.bob.iform.fvm.FvmException;
import com.bob.iform.fvm.FvmContext;
import com.bob.iform.fvm.runtime.FvmFormInstance;

public interface Widget extends Serializable {
	
	void render(FvmFormInstance formInstance,FvmContext context) throws FvmException;

}
