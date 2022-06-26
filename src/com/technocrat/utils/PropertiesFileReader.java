package com.technocrat.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {

	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream("D:\\eclipse-workspace\\TechnoctratBatch4\\config.properties");
		
		Properties properties = new Properties();
		
		properties.load(file);

		System.out.println(properties.getProperty("username"));
		
		System.out.println(properties.getProperty("passwod"));
		
	}
}
