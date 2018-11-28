package com.temp.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	static Random r = new Random();
	
	public static Integer generateInteger() {
		return r.nextInt(20);
	}
}
