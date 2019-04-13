package com.demo.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

public class ReadJson {
	 public static void main(String[] args) throws IOException {
	 /* 
	 * String username = getJsonValue("$.login.username"); 
	 * String password =getJsonValue("$.login.password"); System.out.println(username + password);
	 * 
	 */
		 System.out.println(getJsonValue("$.login.Registration.f_name"));
		 }

//read Json file as $.login.username
	
	
	public static String getJsonValue(String jsonPath) {
		String value = null;
		try {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Login.JSON";
			String jsonString = new String(Files.readAllBytes(Paths.get(path)));
			value = JsonPath.read(jsonString, jsonPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}