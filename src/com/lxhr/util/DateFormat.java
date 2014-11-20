package com.lxhr.util;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期转换类
 * @author yonghe.liu
 *
 * 2014年9月11日
 */

public class DateFormat {
	
	
	
	/**
	 * 日期格式转换 Date返回Date
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static Date dateToDate(Date date,String dateFormat){
		if(date==null){return null;}
		
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		ParsePosition pos = new ParsePosition(0);
		
		Date strtodate = format.parse( format.format(date).toString(),pos);
		return strtodate;
		
	    }
	
	/**
	 * 日期格式转换 String返回Date
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static Date strToDate(String date,String dateFormat){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(date,pos);
		return strtodate;
		
	}
	
	/**
	 * 日期格式转换 Date返回String
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String dateToString(Date date,String dateFormat){
        if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		//ParsePosition pos = new ParsePosition(0);
		
		return format.format(date).toString();
		
	}
	
	/**
	 * 日期格式转换 String返回String 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String strToStr(String date,String dateFormat){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(date,pos);
		
		return format.format(strtodate).toString();
	}
	
	
	
	
	
	
	
	
	public Date getDate(String strDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date=sdf.parse(strDate);
		return date;
	}
	
	

	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(date,pos);
		return strtodate;
		
	}
	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static Date stringToDates(String date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(date,pos);
		return strtodate;
		
	}
	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date stringToDatess(String date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(date,pos);
		return strtodate;
		
	}
	
	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String stringToDay(Date date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		//Date strtodate = format.parse(date,pos);
		
		return format.format(date).toString();
		
	}
	
	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String stringToDays(Date date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ParsePosition pos = new ParsePosition(0);
		//Date strtodate = format.parse(date,pos);
		
		return format.format(date).toString();
		
	}
	
	/**
	 * 字符串转时间格式
	 * yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String stringToDayss(Date date){
		if(date==null){return null;}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		//Date strtodate = format.parse(date,pos);
		
		return format.format(date).toString();
		
	}
	
	/**
	 * 计算两个时间差
	 * @param date1
	 * @param date2
	 * @return 分钟
	 */
	public static String getTimeDifference(Date date1,Date date2){
		StringBuffer df = new StringBuffer();
		
		try{
			//计算单位设置(毫秒1000 * 秒60 * 分60 * 时24);  
			long num = (date1.getTime()-date2.getTime())/(1000*60);
			//if(num>=0)
			df.append(num);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return df.toString();
		
	}
	
	
	/**
	 * 时间交叉判断 返回交叉分钟
	 * 这里共有2个时间段（b1-----e1）【b2-----e2】，4个时间点；
	 *相当于两条线段(b代表起点，e代表端点，b<=e)，4个端点。
	 *
	 *可分3种情况：
	 *1.包含(两条)
	 *（b1---【b2-----e2】--e1）   if(b1<=b2 && e1>=e2)
	 *【b2---（b1-----e1）--e2】   if(b1>=b2&&e1<=e2)
	 *
	 *2.相交(两条)
	 *（b1---【b2---e1）----e2】    if(b1<b2&&e1<e2&&e1>b2)
	 *【b2---(b1---e2】----e1)	 if(b1>b2&&b1<e2&&e2<e1)
	 *
	 *3.不相交
	 *（b1-----e1）【b2-----e2】或【b2-----e2】（b1-----e1）if(e1<b2||b1>e2)此时，重合时间数为零。
	 * @param beginTime1
	 * @param endTime1
	 * @param beginTime2
	 * @param endTime2
	 * @return
	 */
	public static Map<String,Object> getTimeCoincidence(final Date beginTime1,final Date endTime1,final Date beginTime2,final Date endTime2){
		long b1 = beginTime1.getTime();
		long e1 = endTime1.getTime();
		long b2 = beginTime2.getTime();
		long e2 = endTime2.getTime();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//相交分钟数
		String coincidenceTime;
		//相交开始时间
		Date beginTime = null;
		//相交结束时间
		Date endTime = null;
		
		int logicId = 0;
		
		
		if(b1<=b2&&e1>=e2){//（b1---【b2-----e2】--e1）1包含2
			//System.out.println("1包含2");
			coincidenceTime=getTimeDifference(endTime2,beginTime2);
			beginTime = beginTime2;
			endTime = endTime2;
			logicId = 1;
		}else if(b1>=b2&&e1<=e2){//【b2---（b1-----e1）--e2】2包含1
			//System.out.println("2包含1");
			coincidenceTime=getTimeDifference(endTime1,beginTime1);
			beginTime = beginTime1;
			endTime = endTime1;
			logicId =2;
		}else if(b1>=b2&&b1<=e2&&e2<=e1){//（b1---【b2---e1）----e2】 相交1
			//System.out.println("相交");
			coincidenceTime=getTimeDifference(endTime2,beginTime1);
			beginTime = beginTime1;
			endTime = endTime2;
			logicId =3;
		}else if(b1<=b2&&e1<=e2&&e1>=b2){//【b2---(b1---e2】----e1) 相交2
			//System.out.println("相交");
			coincidenceTime=getTimeDifference(endTime1,beginTime2);
			beginTime = beginTime2;
			endTime = endTime1;
			logicId= 4;
		}else if(e1<=b2||b1>=e2){//（b1-----e1）【b2-----e2】或【b2-----e2】（b1-----e1）不相交
			coincidenceTime="0";
		}else{
			coincidenceTime="0";
			//System.out.println("意料外的日期组合，无法计算重合！");
		}
		//System.out.println("重合数为["+coincidenceTime+"]分。");
		
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		map.put("coincidenceTime", coincidenceTime);
		//逻辑循环ID
		map.put("logicId", logicId);
		return map;
		
		
		
	}
	
	
	
	/**
	 * 日期天数加减
	 * @param date1
	 * @param date2
	 * @return 
	 * @throws ParseException 
	 */
	public static Date getIfCrossDays(Date date2,Integer day) {
		
			Calendar cd = Calendar.getInstance();
			cd.setTime(date2);
			cd.add(Calendar.DATE, day);//增加几天   
			
			
			return cd.getTime();
		
		
	}
	
	
	/**
	 * 日期小时加减
	 * @param date1
	 * @param date2
	 * @return 
	 * @throws ParseException 
	 */
	public static Date getCountHour(Date date,Integer hour) {
		
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.HOUR, hour);//增加_减少小时
			
			
			return cd.getTime();
		
		
	}
	
	/**
	 * 日期分钟加减
	 * @param date1
	 * @param date2
	 * @return 
	 * @throws ParseException 
	 */
	public static Date getCountMinute(Date date,Integer minute) {
		
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.MINUTE, minute);//增加_减少分钟
			
			
			return cd.getTime();
		
		
	}
	

	/**
	 * 查询时间段是否包含一个时间 
	 * @param beginTime
	 * @param endTime
	 * @param existTime
	 * @return
	 */
	public static Long getTimeExist(Date beginTime,Date endTime,Date existTime){
		long b = beginTime.getTime();
		long e = endTime.getTime();
		long ex = existTime.getTime();
		
		long timeExist = -1;
		
		if(b <= ex && e >= ex){
			timeExist = Long.parseLong(DateFormat.getTimeDifference(existTime, beginTime));
		}
		
		return timeExist;
		
	}
	
	/**
	 * (公用方法)查询时间段是否包含一个时间
	 * @param beginTime
	 * @param endTime
	 * @param time_be_latess
	 * @return
	 */
	public static Long getTime_be_latess(Date beginTime,Date endTime,Date time_be_latess){
		long b = beginTime.getTime();
		long e = endTime.getTime();
		long ex = time_be_latess.getTime();
		
		long timeExist = -1;
		
		if(b <= ex && e >= ex){
			timeExist = Long.parseLong(DateFormat.getTimeDifference(endTime, time_be_latess));
		}
		
		return timeExist;
		
	}
	
	/*public static Long getTime_frequency(Date beginTime,Date endTime,Date currentTime){
		long b = beginTime.getTime();
		long e = endTime.getTime();
		long c = currentTime.getTime();
		
		long time = 0;
		
		if(b<=c && e>=c){
			time = Long.parseLong(com.util.DateFormat.getTimeDifference(endTime, currentTime));
		}
		
		
		
		return time;
		
	}*/
	
	/**
	 * 工作日天数
	 * @param strStartDate
	 * @param strEndDate
	 * @return
	 */
	public static int getDutyDays(String strStartDate,String strEndDate) {  
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		Date startDate=null;  
		Date endDate = null;  
		  
		try {  
		startDate=df.parse(strStartDate);  
		endDate = df.parse(strEndDate);  
		} catch (ParseException e) {  
		System.out.println("非法的日期格式,无法进行转换");  
		e.printStackTrace();  
		}  
		int result = 0;  
		while (startDate.compareTo(endDate) <= 0) {  
		if (startDate.getDay() != 6 && startDate.getDay() != 0)  
		result++;  
		startDate.setDate(startDate.getDate() + 1);  
		}  
		  
		return result;  
		}  
	
	
	
	
	/*public static void main(String[] args)  {
		System.out.println(getCountMinute(new Date(), -30));
	}*/
	
}
