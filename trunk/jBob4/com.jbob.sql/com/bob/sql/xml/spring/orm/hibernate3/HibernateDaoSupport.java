package com.bob.sql.xml.spring.orm.hibernate3;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.util.ClassUtils;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.builder.XMLMapperBuilder;
import com.bob.sql.xml.mapping.MappedStatement;

public class HibernateDaoSupport extends DaoSupport {

	private final Configuration configuration = new Configuration();

	private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

	private Resource[] configLocations;

	private String[] mappingResources;

	private Resource[] mappingLocations;

	public Resource[] getConfigLocations() {
		return configLocations;
	}

	public void setConfigLocations(Resource[] configLocations) {
		this.configLocations = configLocations;
	}

	public String[] getMappingResources() {
		return mappingResources;
	}

	public void setMappingResources(String[] mappingResources) {
		this.mappingResources = mappingResources;
	}

	public Resource[] getMappingLocations() {
		return mappingLocations;
	}

	public void setMappingLocations(Resource[] mappingLocations) {
		this.mappingLocations = mappingLocations;
	}

	public MappedStatement getMappedStatement(String id) {
		return configuration.getMappedStatement(id);
	}

	private HibernateTemplate hibernateTemplate;

	public final void setSessionFactory(SessionFactory sessionFactory) {
		if (this.hibernateTemplate == null || sessionFactory != this.hibernateTemplate.getSessionFactory()) {
			this.hibernateTemplate = createHibernateTemplate(sessionFactory);
		}
	}

	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	public final SessionFactory getSessionFactory() {
		return (this.hibernateTemplate != null ? this.hibernateTemplate.getSessionFactory() : null);
	}

	public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public final HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	@Override
	protected final void checkDaoConfig() {
		if (this.hibernateTemplate == null) {
			throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
		}
		if (this.mappingResources != null) {
			// Register given Hibernate mapping definitions, contained in resource files.
			for (String mapping : this.mappingResources) {
				Resource resource = new ClassPathResource(mapping.trim(), this.beanClassLoader);
				try {
					XMLMapperBuilder builder = new XMLMapperBuilder(resource.getInputStream(), configuration, mapping);
					builder.parse();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if (this.mappingLocations != null) {
			for (Resource resource : this.mappingLocations) {
				try {
					XMLMapperBuilder builder = new XMLMapperBuilder(resource.getInputStream(), configuration, resource.getFilename());
					builder.parse();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	protected final Session getSession() throws DataAccessResourceFailureException, IllegalStateException {

		return getSession(this.hibernateTemplate.isAllowCreate());
	}

	protected final Session getSession(boolean allowCreate) throws DataAccessResourceFailureException, IllegalStateException {

		return (!allowCreate ? SessionFactoryUtils.getSession(getSessionFactory(), false) : SessionFactoryUtils.getSession(
				getSessionFactory(), this.hibernateTemplate.getEntityInterceptor(), this.hibernateTemplate.getJdbcExceptionTranslator()));
	}

	protected final DataAccessException convertHibernateAccessException(HibernateException ex) {
		return this.hibernateTemplate.convertHibernateAccessException(ex);
	}

	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
	}

}