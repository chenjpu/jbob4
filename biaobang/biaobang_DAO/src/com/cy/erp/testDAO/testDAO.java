package com.cy.erp.testDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cy.erp.daolayer.base.Trackorder;
import com.cy.erp.daolayer.dao.DaoImpl;
import com.cy.erp.daolayer.dao.DaoInit;


public class testDAO extends HibernateDaoSupport {
	private static HibernateTemplate hibernateTemplate;

	private static SessionFactory sessionFactory = null;


	
	static{
		try {
			sessionFactory = DaoInit.init();
			hibernateTemplate = new testDAO().createHibernateTemplate(sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * 默认的构造方法，初始化HibernateTemplate。使用的是默认的配置文件：etc/tipsDao.xml
	 */
	public testDAO() throws Exception {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		try {
			DaoImpl dao=new DaoImpl();
			List list=dao.pubFind("from Trackorder");
			Trackorder bean=(Trackorder)list.get(0);
			System.out.println(bean.getXtime());
//			Trackorder bean=new Trackorder();
//			bean.setId("sadf");
//			bean.setOrderNo("as");
//			dao.save(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static CachedRowSet findBySQL(String sql) throws Exception {
		Connection connection = null;
        PreparedStatement pstmt = null;
        sql="select * from T_BUSI_STATIC_DATA";
        try {
            //oracle连接
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@132.110.40.5:1521:inasfs";
            connection=DriverManager.getConnection(url,"inasfs","inasfs");

            pstmt = connection.prepareStatement(sql); 
            ResultSet rs=pstmt.executeQuery(sql); 
            ResultSetMetaData data=rs.getMetaData(); 
            while(rs.next()){ 
	            for(int i = 1 ; i<= data.getColumnCount() ; i++){ 
	            //获得所有列的数目及实际列数 
	            int columnCount=data.getColumnCount(); 
	            //获得指定列的列名 
	            String columnName = data.getColumnName(i); 
	            //获得指定列的列值 
	            String columnValue = rs.getString(i); 
	            //获得指定列的数据类型 
	            int columnType=data.getColumnType(i); 
	            //获得指定列的数据类型名 
	            String columnTypeName=data.getColumnTypeName(i); 
	            //所在的Catalog名字 
	            String catalogName=data.getCatalogName(i); 
	            //对应数据类型的类 
	            String columnClassName=data.getColumnClassName(i); 
	            //在数据库中类型的最大字符个数 
	            int columnDisplaySize=data.getColumnDisplaySize(i); 
	            //默认的列的标题 
	            String columnLabel=data.getColumnLabel(i); 
	            //获得列的模式 
	            String schemaName=data.getSchemaName(i); 
	            //某列类型的精确度(类型的长度) 
	            int precision= data.getPrecision(i); 
	            //小数点后的位数 
	            int scale=data.getScale(i); 
	            //获取某列对应的表名 
	            String tableName=data.getTableName(i); 
	            // 是否自动递增 
	            boolean isAutoInctement=data.isAutoIncrement(i); 
	            //在数据库中是否为货币型 
	            boolean isCurrency=data.isCurrency(i); 
	            //是否为空 
	            int isNullable=data.isNullable(i); 
	            //是否为只读 
	            boolean isReadOnly=data.isReadOnly(i); 
	            //能否出现在where中 
	            boolean isSearchable=data.isSearchable(i); 
	            System.out.println(columnCount); 
	            System.out.println("获得列"+i+"的字段名称:"+columnName); 
	            System.out.println("获得列"+i+"的字段值:"+columnValue); 
	            System.out.println("获得列"+i+"的类型,返回SqlType中的编号:"+columnType); 
	            System.out.println("获得列"+i+"的数据类型名:"+columnTypeName); 
	            System.out.println("获得列"+i+"所在的Catalog名字:"+catalogName); 
	                System.out.println("获得列"+i+"对应数据类型的类:"+columnClassName); 
	                System.out.println("获得列"+i+"在数据库中类型的最大字符个数:"+columnDisplaySize); 
	                System.out.println("获得列"+i+"的默认的列的标题:"+columnLabel); 
	                System.out.println("获得列"+i+"的模式:"+schemaName); 
	                System.out.println("获得列"+i+"类型的精确度(类型的长度):"+precision); 
	                System.out.println("获得列"+i+"小数点后的位数:"+scale); 
	                System.out.println("获得列"+i+"对应的表名:" + tableName); 
	                System.out.println("获得列"+i+"是否自动递增:"+isAutoInctement); 
	                System.out.println("获得列"+i+"在数据库中是否为货币型:"+isCurrency); 
	                System.out.println("获得列"+i+"是否为空:"+isNullable); 
	                System.out.println("获得列"+i+"是否为只读:"+isReadOnly); 
	                System.out.println("获得列"+i+"能否出现在where中:"+isSearchable);  
	            } 
            } 
        }
        catch (ClassNotFoundException cnfex) {
            cnfex.printStackTrace();
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
		return null;

	}

}
