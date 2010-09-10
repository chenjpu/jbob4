package com.bob.iform.fvm.impl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public final class FormUtils {
	private FormUtils() {

	}
	
	public static boolean isNumber(Object s){
		return s instanceof Number;
	}

	public static boolean isNotEmpty(String s){
		return null !=s && s.trim().length() > 0;
	}
	public static boolean isEmpty(String s){
		return null ==s && s.trim().length() == 0;
	}
	
	
	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}
	
	public static String[] tokenizeToStringArray(
			String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

		if (str == null) {
			return null;
		}
		StringTokenizer st = new StringTokenizer(str, delimiters);
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}
		return toStringArray(tokens);
	}
	
	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new String[collection.size()]);
	}
	
	
}
