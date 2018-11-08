package com.customs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtils {

	public static String getNow() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}
	
	public static String getToday() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy年MM月dd日");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}
	
	public static String getYYYYMMDD() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}
	
	public static String getYYYYMM() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMM");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}
	
	public static String format(String str, String from_format, String to_format) {
		SimpleDateFormat from = new SimpleDateFormat(from_format);
		SimpleDateFormat tod = new SimpleDateFormat(to_format);
		Date retStrFormatNowDate;
		try {
			retStrFormatNowDate = from.parse(str);
			String ret = tod.format(retStrFormatNowDate);
			return ret;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
		
	}
	
	public static Integer add(Integer days){
		Calendar calendar = Calendar.getInstance();
		
		Date nowTime = new Date(System.currentTimeMillis());
        calendar.setTime(nowTime);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, days);
        return (int)(calendar.getTimeInMillis()/1000);
	}
	
	public static Integer add(Integer ts, Integer days){
		Calendar calendar = Calendar.getInstance();
		long aa = (long)ts*1000;
		Date nowTime = new Date(aa);
        calendar.setTime(nowTime);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, days);
        return (int)(calendar.getTimeInMillis()/1000);
	}
	
	public static Integer getNowTimestamp() {
		return (int) (System.currentTimeMillis()/1000);
	}

	public static String unix2Time(Integer time) {
		if (time == null) {
			return "";
		}

		Long timestamp = Long.valueOf(time) * 1000;
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timestamp));
		return date;

	}
	
	public static String unix2Date(Integer time, String format) {
		if (time == null) {
			return "";
		}

		Long timestamp = Long.valueOf(time) * 1000;
		String date = new java.text.SimpleDateFormat(format).format(new java.util.Date(timestamp));
		return date;

	}
	

	public static String unix2Date(Integer time) {
		if (time == null) {
			return "";
		}

		Long timestamp = Long.valueOf(time) * 1000;
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(timestamp));
		return date;

	}
	
	public static Long date2UnixTimestamp(String date) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
	     Date date1;
		try {
			date1 = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	     long timeStemp = date1.getTime()/1000;
	     return timeStemp;	

	}
	
	public static Long YYYYMMDD2UnixTimestamp(String date) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd");
	     Date date1;
		try {
			date1 = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	     long timeStemp = date1.getTime()/1000;
	     return timeStemp;	

	}
	
	public static Integer dateTime2UnixTimestamp(String datetime) {
		if (datetime == null) {
			return null;
		}

	   Calendar c = Calendar.getInstance();  
		    
	   try {
			c.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(datetime));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}  
	   
	   return new Long(c.getTimeInMillis()/1000).intValue();

	}
	
	public static Integer differentDaysBySecond(String dateStr,String dateStr2){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date date2;
		 Date date1;
		try {
			date2 = format.parse(dateStr2);
			date1 = format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
         
        int days = (int) ((date2.getTime() - date1.getTime()) / (3600*1000*24));
        return days;
    }
	
	public static Integer differentSecond(String dateStr,String dateStr2){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date2;
		 Date date1;
		try {
			date2 = format.parse(dateStr2);
			date1 = format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
         
		//  modify by myc,避免差值负数大于int范围
//        int seconds = (int) (date2.getTime() - date1.getTime())/1000;
		long time=date2.getTime() - date1.getTime();
		if (time<0) {
			return 0;
		}
        int seconds = (int) time/1000;
        return seconds;
    }
	
	// 计算从今天到指定时间的日期天数
	public static Integer caculateSencondsFromNow(Integer timestamp){
		String now = format(getNow(), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		String date = unix2Time(timestamp);
		Integer seconds = differentSecond(now, date);
		return seconds;
    }
	
	// 计算从今天到指定时间的日期天数
	public static Integer caculateDaysFromToday(Integer timestamp){
		String now = format(getYYYYMMDD(), "yyyyMMdd", "yyyy-MM-dd");
		String date = unix2Date(timestamp);
		Integer days = differentDaysBySecond(now, date);
		return days;
    }
	
	// 计算从指定时间到指定时间的日期天数
	public static Integer caculateDaysFromCreateTime(Integer fromtime, Integer timestamp){
		String now = unix2Date(fromtime);
		String date = unix2Date(timestamp);
		Integer days = differentDaysBySecond(now, date);
		return days;
    }
	
	public static Calendar getNextMonthDay(Calendar date) {  
	    Calendar next = (Calendar) date.clone();  
	    next.add(Calendar.MONTH, 1);  
	    return next;
	}
	  
	/**
	 * 获取指定日期的下个月的当天（传空则为当天）
	 * @param dateStr
	 * @return
	 */
	public static Calendar getNextMonthDay(String dateStr) {  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
	    try {  
	    	
	    	if(StringUtils.isEmpty(dateStr)){
	    		dateStr = getYYYYMMDD();
	    	}
	        Date date = sdf.parse(dateStr);  
	        Calendar c = Calendar.getInstance();  
	        c.setTime(date);  
	        return getNextMonthDay(c);  
	    } catch (ParseException e) {  
	        throw new IllegalArgumentException("Invalid date format(yyyyMMdd): " + dateStr);  
	    }  
	} 
	public static String unix3Date(String time, String format) throws ParseException {
		if (time == null) {
			return "";
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = (Date) sd.parse(time);
		sd = new SimpleDateFormat(format);
		String strDate = sd.format(date);
		return strDate;

	}
	public static Integer addMonth(Integer month){
		Calendar calendar = Calendar.getInstance();
		
		Date nowTime = new Date(System.currentTimeMillis());
        calendar.setTime(nowTime);
        // add方法中的第二个参数n中，正数表示该日期后n月，负数表示该日期的前n月
        calendar.add(Calendar.MONTH, month);
        return (int)(calendar.getTimeInMillis()/1000);
	}
}