/**
 * 
 */
package com.eshore.inas.daolayer.dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.Mapping;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.type.Type;

/**
 * @author zhangyong
 *
 */
public class Datediff implements SQLFunction {

	public Type getReturnType(Type arg0, Mapping arg1) throws QueryException {
		// TODO 自动生成方法存根
		return Hibernate.INTEGER;
	}

	public boolean hasArguments() {
		// TODO 自动生成方法存根
		return true;
	}

	public boolean hasParenthesesIfNoArguments() {
		// TODO 自动生成方法存根
		return true;
	}

	public String render(List list, SessionFactoryImplementor arg1) throws QueryException {

		if (list.size() ==1) {
			return "datediff( second, "+list.get(0)+" ,getdate())";
             
        }else if(list.size() ==2){
        	return "datediff( second, "+list.get(0)+" ,"+list.get(1)+")";
        }else{
        	throw new IllegalArgumentException("需要1到2个参数!");
        }
		
	}


}
