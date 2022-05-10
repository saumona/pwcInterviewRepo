package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static Properties prop = null;
	static File src = new File("./config.properties");

	public static Properties readConfigFile() {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		return prop;
	}
}
