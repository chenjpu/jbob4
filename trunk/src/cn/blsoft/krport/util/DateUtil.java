/**
 *Created on Jun 25, 2009
 */
package cn.blsoft.krport.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 
 * <p>Description: </p>
 * <p>Created in Jun 25, 2009</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping 
 * @version v1.0
 */
public class DateUtil {
	
    public final static int ERA = 0;

    public final static int YEAR = 1;

    public final static int MONTH = 2;

    public final static int WEEK_OF_YEAR = 3;
    
    public final static int WEEK_OF_MONTH = 4;

    public final static int DATE = 5;

    public final static int DAY_OF_MONTH = 5;
  
    public final static int DAY_OF_YEAR = 6;

    public final static int DAY_OF_WEEK = 7;

    public final static int DAY_OF_WEEK_IN_MONTH = 8;

    public final static int AM_PM = 9;


    public final static int HOUR = 10;


    public final static int HOUR_OF_DAY = 11;


    public final static int MINUTE = 12;


    public final static int SECOND = 13;


    public final static int MILLISECOND = 14;


    public final static int ZONE_OFFSET = 15;


    public final static int DST_OFFSET = 16;


    public final static int FIELD_COUNT = 17;
    
    public final static Map<String,Integer> UT = new HashMap<String,Integer>();
    
    static{
    	UT.put("y", YEAR);
    	UT.put("M", MONTH);
    	UT.put("d", DATE);
    	UT.put("H", HOUR_OF_DAY);
    	UT.put("m", MINUTE);
    	UT.put("s", SECOND);
    }
    
	/**
	 * 返回behindDate-beforeDate的时间差，返回以“x天y小时z分钟”形式
	 * @param beforeDate
	 * @param behindDate
	 * @return
	 */
	public static int getRemnantTime(Date beforeDate, Date behindDate){
		int time = (int) ((behindDate.getTime() - beforeDate.getTime())/60000);
		return time;
	}
	
	/**
	 * 返回当前时间到behindDate的时间差，返回以“x天y小时z分钟”形式
	 * @param beforeDate
	 * @return
	 */
	public static int getRemnantTime(Date behindDate){
		return getRemnantTime(new Date(), behindDate);
	}
	
	/**
	 * 字符串生成时间
	 * @param dateString
	 * @param pattern
	 * @return
	 */
	public static Date StirngToDate(String dateString, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 时间生成字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);	
		return sdf.format(date);		
	}
	
	public static String minuteToDHM(int minute){
		String flag = "";
		if(minute<0){
			flag = "-";
			minute *= -1;
		}
		int intDay = minute/1440;
		int intHour = (minute - intDay*1440)/60;
		int intMinutes = minute - intDay*1440 - intHour*60;
		return flag + (intDay==0?"":intDay+"天") + (intHour==0?"":intHour+"小时") + (intMinutes==0?"":intMinutes+"分钟");
	}
	
	/**
	 * Description: 移动时间
	 * @param date 基准日期
	 * @param second 移动幅度(秒)
	 * @return
	 */
	public static Date moveDate(Date date, long second){
		return new Date(date.getTime()+second*1000);
	}
	

	/**
	 * Description:  移动时间
	 * @param date 基准日期
	 * @param field 单位
	 * @param amount 移动幅度
	 * @return
	 */
	public static Date moveDate(Date date,int field, int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	public static Date moveDate(Date date,String arithmetic){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String[] ops = arithmetic.replace(" ", "").replace("+", " +").replace("-", " -").replace(".", " .").trim().split(" ");
		for(String op:ops){
			if(op.startsWith(".")){				
				calendar.set(UT.get(op.substring(op.length()-1)),Integer.parseInt(op.substring(1,op.length()-1)));
			}else if(op.startsWith("+")){
				calendar.add(UT.get(op.substring(op.length()-1)),Integer.parseInt(op.substring(1,op.length()-1)));
			}else if(op.startsWith("-")){
				calendar.add(UT.get(op.substring(op.length()-1)),Integer.parseInt(op.substring(0,op.length()-1)));
			}
		}
		return calendar.getTime();
	}
	
	public static void main(String[] arg){
		System.out.println(DateUtil.DateToString(moveDate(new Date(), "-1D-1M.16H.0m.0s+1H"),"yyyy-MM-dd HH:mm:ss"));		
	}
	
}
