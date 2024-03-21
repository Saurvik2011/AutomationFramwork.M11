package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {
		//Step 1 :Open the document in java readable format 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Step 2 :Create Object of Properties class from java.util
		Properties p = new Properties();
		//Step 3 :Load the data to properties file
		p.load(fis);
		//Step 4 :Provide the key and fetch the value
		String value = p.getProperty("username");
		System.out.println(value);
		String value1 = p.getProperty("url");
		System.out.println(value1);
		
		

	}

}
