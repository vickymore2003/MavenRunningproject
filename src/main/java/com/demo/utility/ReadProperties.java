package com.demo.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ReadProperties {
	public String getProperties(String key) {
		StartUpInitilize initilize = new StartUpInitilize();
		Properties prop = new Properties();
		String value = null;
		try {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\EnvProp\\" + initilize.getEnvName()	+ ".properties";
			System.out.println(path);
			File f = new File(path);
			FileReader reader = new FileReader(f);
			prop.load(reader);
			value = prop.getProperty(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		StartUpInitilize initilize = new StartUpInitilize();
		System.out.println("HI");
		initilize.setEnvName("UAT");
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\EnvProp\\" + initilize.getEnvName()
				+ ".properties";
		System.out.println(path);
	}
}