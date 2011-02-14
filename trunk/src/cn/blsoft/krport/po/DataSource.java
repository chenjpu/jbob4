/**
 * Created on 2010-5-15
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

/**
 * <p>Title:  DataSource.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class DataSource {
	
	private String driver;
	
	private String url;
	
	private String username;
	
	private String password;

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
