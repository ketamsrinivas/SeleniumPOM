/**
 * 
 */
package com.seleniumpom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sketam
 *
 */
public class UtilityMethods {

	/**
	 * 
	 */
	Properties prop = new Properties();
	String projectPath = System.getProperty("user.dir");
	String filePath = System.getProperty("user.dir") + File.separator
			+ "src\\test\\java\\com\\seleniumpom\\testdata\\Config.Properties";

	public String getProperty(String str) {
		String strValue = "";
		File f = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(f);

			if (f.exists()) {
				try {
					prop.load(fis);
					strValue = prop.getProperty(str);
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
		}
		return strValue;

	}

}
