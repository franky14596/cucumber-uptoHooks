package com.flip.stepdefenitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	static WebDriver driver;
	@Before
	public void beforelaunch() {
		 WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.get("https://www.flipkart.com/");
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	}
	
	@After
	public void browserQuit() {
		
		 driver.quit();
	}
	
	
}
