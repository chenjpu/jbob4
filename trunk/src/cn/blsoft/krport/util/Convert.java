/**
 * Created on 2010-5-3
 * @version v1.0
 *
 */
package cn.blsoft.krport.util;

/**
 * <p>Title:  Convert.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class Convert {
	
	public static Integer stringToInteger(String string){
		try{
			return Integer.parseInt(string);
		}catch(Exception e){
			return null;
		}
	}
	
	public static int stringToInt(String string){
		try{
			return Integer.parseInt(string);
		}catch(Exception e){
			return 0;
		}
	}

	public static Boolean stringToBoolean(String string) {
		return string!=null&&"true".equalsIgnoreCase(string.trim());
	}
}
