package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class method {

	public static int dateDiff(String dateFromString, Date dateToString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    Date dateTo = null;
	    Date dateFrom = null;


	    dateTo = dateToString ;
	    // Date型に変換
	    try {
	        dateFrom = sdf.parse(dateFromString);
	    } catch (java.text.ParseException e) {
	        e.printStackTrace();
	    }

	    // 差分の日数を計算する
	    long dateTimeTo = dateTo.getTime();
	    long dateTimeFrom = dateFrom.getTime();
	    long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 * 24 );

	    System.out.println( "差分日数 : " + dayDiff );
	    return (int) dayDiff;
	}

}
