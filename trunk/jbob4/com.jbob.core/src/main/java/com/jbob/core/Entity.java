package com.jbob.core;

import java.io.Serializable;


/**
 * @author chenb
 * 
 */
public abstract class Entity implements Serializable {
	private static final long serialVersionUID = -3170478118632726560L;
	public abstract Serializable getId();
}
