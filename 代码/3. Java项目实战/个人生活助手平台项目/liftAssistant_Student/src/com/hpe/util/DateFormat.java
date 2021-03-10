package com.hpe.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String myDateFormat() {
		Date d=new Date();
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}

}
