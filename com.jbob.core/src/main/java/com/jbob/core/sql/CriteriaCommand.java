package com.jbob.core.sql;

import org.hibernate.Criteria;

/**
 * Creates a command to wrap the Hibernate criteria API.
 * @author csx
 * 
 */
public interface CriteriaCommand {
	public final static String SORT_DESC="desc";
	public final static String SORT_ASC="asc";
	
	public Criteria execute(Criteria criteria);
}
