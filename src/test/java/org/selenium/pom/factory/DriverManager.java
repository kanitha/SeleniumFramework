package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public enum Browser {
		CHROME, FIREFOX
	}
	
	public WebDriver initializeDriver(String browser) {
//		WebDriverManager.chromedriver().cachePath("D:\\Software Installers").setup();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Installers\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Software Installers\\geckodriver\\geckodriver.exe");
		//To use a default value when the property is not set explicitly
		String browserName = System.getProperty("browser", browser);
		
		WebDriver driver;
		
		switch(Browser.valueOf(browserName)){
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalStateException("Invalid browser name - " + browserName);
		}

		driver.manage().window().maximize();
		return driver;
	}
}
