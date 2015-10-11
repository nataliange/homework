package com.example.fw;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	private WebDriver driver;
	public String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private HibernateHelper hibernateHelper;
	private Properties properties;
	private ApplicationModel model;
	
	public ApplicationManager(Properties properties)	{
		this.properties = properties;
		model = new ApplicationModel();
		model.setGroups(getHibernateHelper().listGroups());
	}
	
	public void stop() {
		driver.quit();
	}
	
	public ApplicationModel getModel() {
		return model;
	}

	public NavigationHelper navigateTo() {
		if (navigationHelper==null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper==null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper==null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;	
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();
			} else if ("ie".equals(browser)) {
				driver = new InternetExplorerDriver();
			} else {
				throw new Error("Unsupported browser: " + browser);
			}
		    baseUrl = properties.getProperty("baseUrl");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//System.setProperty("webdriver.ie.driver", "C:\\Users\\Nata\\IEDriverServer.exe");
		    //WebDriver driver=new InternetExplorerDriver();   
			driver.get(baseUrl);
		    driver.manage().window().maximize();  
		}
		return driver;	
}
	public String getProperty(String key) {
		return properties.getProperty(key);
	}


}



