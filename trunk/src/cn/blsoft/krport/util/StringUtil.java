/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.util;

/**
 * <p>Title:  StringUtil.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class StringUtil {

	public static String objectToString(Object obj){
		if(null == obj){
			return "";
		}else{
			return obj.toString();
		}
	}
	
	public static boolean isBlank(String str){
		return null==str || "".equals(str);
	}
	
	public static String arrayToString(Object[] objs, String regex){
		StringBuffer merge = new StringBuffer();
		if(null == objs) return "";
		for(int i=0;i<objs.length;i++){
			merge.append(objectToString(objs[i]));
			if(i<objs.length-1){
				merge.append(regex);
			}
		}
		return merge.toString();
	}
	
	public static String toHtmlString(Object obj){
		return objectToString(obj)
			.replace("&", "&amp;")
			.replace("<", "&lt;")
			.replace(">", "&gt;")
			.replace("\"", "&quot;");
	}
	
	//È¥ÒýºÅ
	public static String toJSString(Object obj){		
		return objectToString(obj)
			.replace("'", "\\'")
			.replace("\"", "\\\"");
	}
	
    public static String toStandardStr(String strOrigin)
    {
        if (strOrigin == null || strOrigin.equals(null))
        {
            strOrigin = "";
        }
        else
        {
            strOrigin = strOrigin.trim();
        }

        try
        {
            strOrigin = new String(strOrigin.getBytes("GBK"), "ISO8859_1");
        }
        catch (Exception e)
        {
        }
        return strOrigin;
    }
}
