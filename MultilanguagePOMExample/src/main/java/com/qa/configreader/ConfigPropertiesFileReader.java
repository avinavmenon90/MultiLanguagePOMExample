package com.qa.configreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * This java class is used to read values from the
 * properties file based on the language selected
 * 
 */

public class ConfigPropertiesFileReader {
	
	private Properties prop;
	private FileInputStream fis;
	private File src;

	
	public Properties initLangProp() {
		
		//mvn clean install -Dlang="French"
		
		String language = System.getProperty("lang"); //getting variable from command line during maven build
		
		System.out.println("language is: "+language);
		
		prop = new Properties();
		
		if((language.equalsIgnoreCase("english"))){
			
			//read English properties file
			  src = new File("./src/main/resources/lang-english.properties");
			  try {
				fis = new FileInputStream(src);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to read properties file due to: "+e.getMessage());
				//e.printStackTrace();
			}
		}
		else if((language.equalsIgnoreCase("french"))){
			
			//read French properties file
			   src = new File("./src/main/resources/lang-french.properties");
			   try {
				fis = new FileInputStream(src);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to read properties file due to: "+e.getMessage());
				e.printStackTrace();
			}
		}
		else		
		System.out.println("This language is not found: "+language);
	
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("ERROR: properties file NOT FOUND for this language");
			e.printStackTrace();
		}
		
	return prop;
	}

}
