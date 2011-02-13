package com.cy.erp.daolayer.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 实现了DAO接口的实现类，在这里集中为所有的pojo提供通用的增，删，查，改的方法。
 */
public class DaoImpl extends HibernateDaoSupport {

	private static HibernateTemplate hibernateTemplate;

	private static SessionFactory sessionFactory = null;

	public static Logger logger = Logger.getLogger(DaoImpl.class);

	public static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	static {
		try {
			sessionFactory = DaoInit.init();
			hibernateTemplate = new DaoImpl()
					.createHibernateTemplate(sessionFactory);
		} catch (Exception e) {
			logger.error("spring集成hibernate异常,系统中止执行", e);
			System.exit(-1);
		}
	}

	/**
	 * 默认的构造方法，初始化HibernateTemplate。使用的是默认的配置文件：etc/tipsDao.xml
	 */
	public DaoImpl() throws Exception {
		super.setHibernateTemplate(hibernateTemplate);
	}

	/**
	 * 根据主键查找一条记录
	 * 
	 * @param pk：主键
	 *            className:你要操作的表对象
	 * @return Object:一个表对象
	 */
	public Object findByKey(Serializable pk, Class<?> className)
			throws Exception {
		Object obj = null;
		try {
			obj = getHibernateTemplate().get(className, pk);
			logger.info("根据主键查询" + className
					+ "对象成功！DaoImlp.java->findByKey(pk,class)");
			if (obj == null) {
				logger.info("数据库没有符合条件的记录！[" + className.getName()
						+ "]DaoImlp.java->findByKey(pk,class)");
				return null;
			}
		} catch (Exception e) {
			logger.error("根据主键查询" + className
					+ "对象失败！DaoImlp.java->findByKey(pk,class)");
			throw e;
		}
		return obj;
	}

	/**
	 * 查找所有的记录
	 * 
	 * @param className:你要操作的表对象
	 * @return List:所有的表记录
	 */
	public List<?> findAll(String className) throws Exception {
		List<?> list = null;
		try {
			list = getHibernateTemplate().find("from " + className);
			logger.info("查询所有的" + className
					+ "对象成功！DaoImlp->findAll(className)");
			if (list.isEmpty()) {
				logger.info("数据库没有符合条件的记录！[from " + className
						+ "]DaoImlp.java->findAll(className)");
			}
		} catch (Exception e) {
			logger.error("查询" + className + "对象失败！DaoImlp->findAll(className)");
			throw e;
		}
		return list;
	}

	/**
	 * 分页查询 由你给出HQL查询语句，可以跟排序函数。比如：<br>
	 * from TNode t order by t.id asc<br>
	 * TNode是对象，t是别名，order by是排序函数，t.id是要按照属性id来排序，asc是升序（desc是降序）<br>
	 * 该方法调用示例：<br>
	 * List list=dao.findPage("from TNode t order by t.id asc",2,5);<br>
	 * 注意参数，第一个是查询语句；"2"和"5"表示是从第二条记录开始，查5条记录出来.
	 * 
	 * @param HQL:你给出的查询语句
	 *            first:当页开始的行号 count：每页记录数
	 * @return List:所有分页的表记录
	 */
	public List<?> findPage(String HQL, int first, int count) throws Exception {
		List<?> list = null;

		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query q = session.createQuery(HQL);
			q.setFirstResult(first);
			q.setMaxResults(count);
			list = q.list();

			logger.info("分页查询成功！[" + HQL + "," + first + "," + count
					+ "]DaoImlp.java->findPage(HQL,first,count)");
		} catch (Exception e) {
			logger.error("分页查询失败！[" + HQL + "," + first + "," + count
					+ "]DaoImlp.java->findPage(HQL,first,count)");
			throw e;
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
		return list;
	}

	/**
	 * 通过某一字段来查找记录
	 * 
	 * @param property:属性值
	 *            propertyType：属性名 className:你要操作的表对象
	 * @return List：所有符合条件的表记录
	 */
	public List<?> findByProperty(Object property, String propertyName,
			String ClassName) throws Exception {
		List<?> list = null;
		try {
			if (property instanceof String) {
				list = getHibernateTemplate().find(
						"from " + ClassName + " as t where t." + propertyName
								+ " ='" + property + "'");
			} else {
				list = getHibernateTemplate().find(
						"from " + ClassName + " as t where t." + propertyName
								+ " =" + property);
			}
			logger.info("查询所有符合条件“" + property + "”的" + ClassName
					+ "对象成功！DaoImlp.java->findByProperty(...)");
		} catch (Exception e) {
			logger.error("查询所有符合条件“" + property + "”的" + ClassName
					+ "对象失败！DaoImlp.java->findByProperty(...)");
			throw e;
		}
		return list;
	}

	/**
	 * 增加一条记录
	 * 
	 * @param ojb:你要增加的对象
	 * @return boolean ：成功则返回true，否则返回false
	 */
//	public Serializable save(Object ojb) throws Exception {
//		try {
//			Serializable srl = getHibernateTemplate().save(ojb);
//			logger.info("保存对象“" + ojb + "”成功！DaoImlp.java->save()");
//			return srl;
//		} catch (Exception e) {
//			if ((e.getMessage().indexOf(
//					"Explicit value specified for identity field in table") != -1)
//					&& (e.getMessage().indexOf("is OFF") != -1)) {
//				logger
//						.error("mapping error！数据库主键为自增序列，程序里PK设置成编码处理，该错误请联系DAO管理员！DaoImlp.java->save(ojb)");
//			}
//			if (e instanceof IdentifierGenerationException) {
//				logger
//						.error("可能缺少主键！当数据库主键为非自增序列时需要程序来处理主键生成！DaoImlp.java->save("
//								+ ojb.getClass().getName() + ")");
//			}
//			logger.error("保存对象“" + ojb + "”失败！DaoImlp.java->save("
//					+ ojb.getClass().getName() + ")");
//			throw e;
//
//		}
//	}
	
	/**
	 * 增加一条记录
	 * 
	 * @param ojb:你要增加的对象
	 * @return boolean ：成功则返回true，否则返回false
	 */
	public boolean save(Object ojb) throws Exception {
		try {
			getHibernateTemplate().save(ojb);
			logger.info("保存对象“" + ojb + "”成功！DaoImlp.java->save()");
			return true;
		} catch (Exception e) {
			if ((e.getMessage().indexOf(
					"Explicit value specified for identity field in table") != -1)
					&& (e.getMessage().indexOf("is OFF") != -1)) {
				logger
						.error("mapping error！数据库主键为自增序列，程序里PK设置成编码处理，该错误请联系DAO管理员！DaoImlp.java->save(ojb)");
			}
			if (e instanceof IdentifierGenerationException) {
				logger
						.error("可能缺少主键！当数据库主键为非自增序列时需要程序来处理主键生成！DaoImlp.java->save("
								+ ojb.getClass().getName() + ")");
			}
			logger.error("保存对象“" + ojb + "”失败！DaoImlp.java->save("
					+ ojb.getClass().getName() + ")");
			throw e;

		}
	}

	/**
	 * 修改一条记录，只需要修改对象的属性，hibernate会自动同步到数据库
	 * 
	 * @param obj:你修改好的对象
	 * @return boolean 是否成功
	 */
	public boolean update(Object obj) throws Exception {

		try {
			getHibernateTemplate().update(obj);
			logger.info("修改对象“" + obj.getClass().getName() + "”成功！DaoImlp.java->update(obj)");
			return true;
		} catch (Exception e) {
			if (e.getMessage().indexOf("count: 0") != -1)
				logger.error("数据库没有该条记录！[" + obj.getClass().getName()
						+ "]DaoImlp.java->update(obj)");
			logger.error("修改对象“" + obj.getClass().getName()
					+ "”失败！DaoImlp.java->update(obj)");

			throw e;

		}
	}

	/**
	 * 删除一条记录
	 * 
	 * @param ojb:你要删除的对象
	 * @return boolean 是否成功
	 */
	public boolean delete(Object ojb) throws Exception {
		try {
			getHibernateTemplate().delete(ojb);
			logger.info("删除对象“" + ojb.getClass().getName()
					+ "”成功！DaoImlp.java->delete(ojb)");
			return true;
		} catch (Exception e) {
			if (e.getMessage().indexOf("count: 0") != -1)
				logger.error("数据库没有该条记录！[" + ojb.getClass().getName()
						+ "]DaoImlp.java->delete(ojb)");
			logger.error("删除对象“" + ojb.getClass().getName()
					+ "”失败！DaoImlp.java->delete(ojb)");
			throw e;

		}
	}

	/**
	 * 执行通用的查询
	 * 
	 * @param HQL：定制的HQL查询语句
	 * @return list 所有符合条件的记录
	 */
	public List<?> pubFind(String HQL) throws Exception {
		List<?> list = null;
		try {
			list = getHibernateTemplate().find(HQL);
			logger.info("执行HQL查询成功！[" + HQL + "]DaoImlp.java->findPage");
			if (list.isEmpty()) {
				logger.info("数据库没有符合条件的记录！[" + HQL
						+ "]DaoImlp.java->pubFind(HQL)");
			}
		} catch (Exception e) {
			logger.error("执行HQL查询失败！[" + HQL
					+ "].java->DaoImlp.java->pubFind(HQL)");

			throw e;
		}
		return list;
	}

	/**
	 * 执行通用的增，删，改操作
	 * 
	 * @param HQL：定制的HQL语句
	 * @return boolean 成功与否
	 */
	public boolean pubExe(String HQL) throws Exception {

		Session session = null;
		Transaction transaction = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery(HQL);
			q.executeUpdate();
			transaction.commit();

			logger.info("执行通用HQL成功！[" + HQL + "]");
			return true;
		} catch (Exception e) {
			logger.error("执行通用HQL异常[" + HQL + "]，操作回退", e);
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception ex1) {
					logger.error("操作回退异常", ex1);
				}
			}
			throw e;
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
	}

	/**
	 * 根据(单)主键ID删除记录. 主键只能为8种基本类型和String型
	 * 
	 * @param PK:主键
	 *            className：对象所属的类
	 * @return boolean 是否成功
	 */
	public boolean delByKey(Serializable PK, Class<?> className)
			throws Exception {

		Session session = null;
		Transaction transaction = null;
		try {
			Object obj = this.findByKey(PK, className);
			if (obj == null) {
				logger.info("根据主键删除记录失败，可能没有该记录！[" + PK.getClass().getName()
						+ "," + className.getName()
						+ "]DaoImlp.java->delByKey(PK,className)");
				return false;
			}
			String hql = null;
			if (PK instanceof String) {
				hql = "delete " + className.getName() + " where id='" + PK
						+ "'";
			} else {
				hql = "delete " + className.getName() + " where id=" + PK;
			}

			session = getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.executeUpdate();
			transaction.commit();

			logger.info("根据主键删除记录ok![" + hql
					+ "]DaoImlphqldelByKey(PK,className)");
			return true;
		} catch (Exception e) {
			logger.error("根据主键删除记录异常[" + PK.getClass().getName() + ","
					+ className.getName() + "]操作回退...", e);
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception ex1) {
					logger.error("操作回退异常", ex1);
				}
			}
			throw e;
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
	}

	/**
	 * 根据复合主键类的多个属性删除记录. 将主键包含的属性单独传入
	 * 
	 * @param PK:主键的一个属性
	 *            pkName:属性的名字 className：对象所属的类
	 * @return boolean 是否成功
	 */
	public boolean delByKey(Serializable PK1, String pk1Name, Serializable PK2,
			String pk2Name, String className) throws Exception {

		Session session = null;
		Transaction transaction = null;
		try {
			String hql = null;
			String key1 = PK1.toString();
			String key2 = PK2.toString();
			if (PK1 instanceof String && PK2 instanceof String) {
				hql = "delete " + className + " where id." + pk1Name + "='"
						+ key1 + "' and id." + pk2Name + "='" + key2 + "'";
			} else if ((!(PK1 instanceof String)) && (!(PK2 instanceof String))) {
				hql = "delete " + className + " where id." + pk1Name + "="
						+ key1 + " and id." + pk2Name + "=" + key2;
			} else if (PK2 instanceof String) {
				hql = "delete " + className + " where id." + pk1Name + "="
						+ key1 + " and id." + pk2Name + "='" + key2 + "'";
			} else if (PK1 instanceof String) {
				hql = "delete " + className + " where id." + pk1Name + "='"
						+ key1 + "' and id." + pk2Name + "=" + key2;
			} else {
				logger
						.error("根据复合主键删除记录失败！可能参数类型不匹配！DaoImlp.java->delByKey(...)");
				return false;
			}
			session = getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.executeUpdate();
			transaction.commit();

			logger.info("根据复合主键删除记录ok!DaoImlp.java->delByKey(...)");
			return true;
		} catch (Exception e) {
			logger.error("根据复合主键删除记录异常", e);
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception ex1) {
					logger.error("事务回滚失败", ex1);
				}
			}
			throw e;
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
	}

	/**
	 * 根据传入的SQL语句进行查询<br>
	 * 比如：<br>
	 * DaoImpl dao=new DaoImpl();<br>
	 * CachedRowSet rs=dao.findBySQL("select * from t_workorder_status");<br>
	 * try {<br>
	 * while(rs.next()){<br>
	 * Object obj1=rs.getObject(1);<br>
	 * Object obj2=rs.getObject(2);<br>
	 * Object obj3=rs.getObject(3);<br>
	 * Object obj4=rs.getObject(4);<br>
	 * System.out.println(obj1.toString()+obj2+obj3+obj4);<br> }<br> } catch
	 * (SQLException e) {<br>
	 * e.printStackTrace();<br> }<br> }<br>
	 * 由于该方法必须返回结果集，故不可执行增删改语句；<br>
	 * 
	 * @param sql
	 *            SQL语句
	 * @return CachedRowSet对象，可以象操作ResulSet一样操作。它缓存了断开数据库后的结果集。
	 */
	public CachedRowSet findBySQL(String sql) throws Exception {

		Session session = null;
		Connection conn = null;
		CachedRowSet empl = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			conn = session.connection();
			empl = new CachedRowSetImpl();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			empl.populate(rs);
			logger.info("根据SQL查询ok![" + sql + "]DaoImlp.java->findBySQL(sql)");
			return empl;
		} catch (Exception e) {
			logger.info("根据SQL查询失败![" + sql + "]DaoImlpf.java->findBySQL(sql)");

			throw e;

		} finally {
			// if (empl != null) {
			// try {
			// empl.close();
			// } catch (Exception ex) {
			// logger.error(ex, ex.getMessage());
			// }
			// }
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
			if (sta != null) {
				try {
					sta.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
	}

	/**
	 * 直接传入SQL语句执行增删改操作。无结果集返回，故不可进行查询操作
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 成功与否
	 */
	public boolean executeBySQL(String sql){

		Session session = null;
		Connection conn = null;
		Statement sta = null;
		Transaction transaction = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			conn = session.connection();
			sta = conn.createStatement();
			sta.execute(sql);
			transaction.commit();

			logger.info("执行SQL语句成功![" + sql + "]DaoImlp.java->executeBySQL(String sql)");
			return true;
		} catch (Exception e) {
			logger.info("执行SQL[" + sql + "]语句异常，操作回退...", e);
			if (transaction != null) {
				try {
					transaction.rollback();
				} catch (Exception ex1) {
					logger.error("操作回退异常", ex1);
				}
			}
			e.printStackTrace();
		} finally {
			if (sta != null) {
				try {
					sta.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}
		}
		return false;
	}
}
