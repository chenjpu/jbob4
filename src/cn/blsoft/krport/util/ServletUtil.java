/**
 * Created on 2010-6-8
 * @version v1.0
 *
 */
package cn.blsoft.krport.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.initparam.Initparam;

/**
 * <p>Title:  ServletUtil.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ServletUtil {
		
	@SuppressWarnings("unchecked")
	public static Map<String, Object> initParam(HttpServletRequest request)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        for(Initparam initparam:KReportContext.config.getInitparams().values()){
        	param.putAll(initparam.getParam(request));
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Entry<String, String[]> entry : parameterMap.entrySet())
        {
            String[] value = entry.getValue();
            if (value.length == 1)
            {
                param.put(entry.getKey(), value[0]);
            }
            else
            {
                param.put(entry.getKey(), value);
            }
        }
        return param;
    }
	
	public static String getKReportName(HttpServletRequest request){
		String kReportName = request.getServletPath();
		kReportName=kReportName.substring(0, kReportName.lastIndexOf("."));
		return kReportName;
	}
	
	public static String getKReportName(String name){
		String kReportName = name;
		kReportName=kReportName.substring(0, kReportName.lastIndexOf("."));
		return kReportName;
	}
}
