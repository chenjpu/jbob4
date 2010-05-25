package com.jbob.core.batis.support;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import com.jbob.core.batis.BatisTemplate;

public abstract class BatisDaoSupport extends DaoSupport {

	private BatisTemplate batisTemplate = new BatisTemplate();

	private boolean externalTemplate = false;

	public final void setDataSource(DataSource dataSource) {
		if (!this.externalTemplate) {
			this.batisTemplate.setDataSource(dataSource);
		}
	}

	public final DataSource getDataSource() {
		return this.batisTemplate.getDataSource();
	}

	public final void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (!this.externalTemplate) {
			this.batisTemplate.setSqlSessionFactory(sqlSessionFactory);
		}
	}

	public final SqlSessionFactory getSqlSessionFactory() {
		return this.batisTemplate.getSqlSessionFactory();
	}

	public final void setBatisTemplate(BatisTemplate sqlSessionTemplate) {
		Assert.notNull(sqlSessionTemplate, "SqlSessionTemplate must not be null");
		this.batisTemplate = sqlSessionTemplate;
		this.externalTemplate = true;
	}
	
	public final BatisTemplate getBatisTemplate() {
		 return this.batisTemplate;
	}

	protected final void checkDaoConfig() {
		if (!this.externalTemplate) {
			this.batisTemplate.afterPropertiesSet();
		}
	}

}
