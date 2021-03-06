/** 
 * 
 */
package com.seleniumpom.utilities;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author sketam
 *
 */
public class Base {

	public WebDriver driver;
	public WebDriverWait wait;
	UtilityMethods utility = new UtilityMethods();
	String driverPath;
	String projectPath = System.getProperty("user.dir");
	String browserType = utility.getProperty("browserName");
	String env = utility.getProperty("env");

	@BeforeClass
	public void initializeBrowser() {

		if (browserType.equalsIgnoreCase("Chrome")) {
			driverPath = utility.getProperty("chromePath");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to(env);

		} else if (browserType.equalsIgnoreCase("FireIEfox")) {
			driverPath = utility.getProperty("firefoxPath");
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to(env);

		} else if (browserType.equalsIgnoreCase("msEdgeBrowser")) {
			driverPath = utility.getProperty("MSWeb");
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.navigate().to(env);

		}

	}

//	@AfterClass
	public void quit() {
		driver.close();

	}

}
