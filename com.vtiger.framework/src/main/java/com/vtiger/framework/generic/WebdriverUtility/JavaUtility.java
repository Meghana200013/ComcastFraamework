package com.vtiger.framework.generic.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int ranNum = r.nextInt(5000);
		return ranNum;
	}
	
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String systemDate = sdf.format(d);
		return systemDate;
	}
	public String getRequiredDate(int days)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    Calendar cal = Calendar.getInstance(); // ✅ correct current date
	    cal.add(Calendar.DAY_OF_MONTH, days);

	    String reqDate = sdf.format(cal.getTime());
	    return reqDate;
	}

}
