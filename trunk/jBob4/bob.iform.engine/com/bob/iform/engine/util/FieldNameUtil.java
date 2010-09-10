package com.bob.iform.engine.util;

import java.util.HashMap;
import java.util.Map;

public class FieldNameUtil {

	private final static Map<String, String> MAP = new HashMap<String, String>();

	static {
		MAP.put("boolean", "Z");
		MAP.put("char", "C");
		MAP.put("byte", "B");
		MAP.put("short", "S");
		MAP.put("int", "I");
		MAP.put("float", "F");
		MAP.put("long", "J");
		MAP.put("double", "D");
		MAP.put("string", "ST");
		MAP.put("date", "DT");
	}

	private FieldNameUtil() {

	}
	
	public static final String getUIName(String name,String type){
		return "F_" + name + "_" + MAP.get(type);
	}

}
