package com.flip.stepdefenitions;

import java.util.List;
import java.util.Map;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class TelevisionValidation {
	
	static String name1;
	static String tn;
	
	@Given("User launches Flipkart Application")
	public void user_launches_Flipkart_Application() {
    
     }

	@When("User logins Flipkart")
	public void user_logins_Flipkart() {
		WebElement close = Hooks.driver.findElement(By.xpath("//button[text()='✕']"));
	   close.click();
	}

	@When("User searches Television")
	public void user_searches_Television() {
		WebElement search = Hooks.driver.findElement(By.name("q"));
		tn=("samsung tv");
		search.sendKeys(tn,Keys.ENTER);
		}

	@When("User clicks Telivision")
	public void user_clicks_Telivision() {
		WebElement selecttv = Hooks.driver.findElement(By.xpath("(//div[contains(text(),'LED Smart')])[6]"));
        String name1 = selecttv.getText();
        System.out.println(name1);
		selecttv.click();	   
	}

	@Then("User validates Television Name")
	public void user_validates_Television_Name() {
		
		String Parent = Hooks.driver.getWindowHandle();
		Set<String> child = Hooks.driver.getWindowHandles();
		for (String x : child) {
		if(!Parent.equals(child)) {
			Hooks.driver.switchTo().window(x);
		}
	   }
	
		WebElement product = Hooks.driver.findElement(By.xpath("//span[contains(text(),'LED Smart')]"));
		Assert.assertTrue(product.isDisplayed());
	    String name2 = product.getText();
	    System.out.println(name2);
	    
	    //Assert.assertEquals(name1, name2);
	    
	   
	    }
	@When("User searches Television by one dimensional List")
	public void user_searches_Television_by_one_dimensional_List(DataTable dataTable) {
	   List<String> searchinputs = dataTable.asList();
	   WebElement search = Hooks.driver.findElement(By.name("q"));
	   tn=searchinputs.get(1);
	   search.sendKeys(tn,Keys.ENTER);
	   
	}
	
	@When("User searches Television by one dimensional Map")
	public void user_searches_Television_by_one_dimensional_Map(DataTable dataTable) {
	  Map<String,String> searchinput = dataTable.asMap(String.class, String.class);
	  WebElement search = Hooks.driver.findElement(By.name("q"));
	  tn=searchinput.get("2");
	  search.sendKeys(tn,Keys.ENTER); 
	  
	}
	
	@When("User searches Television {string}")
	public void user_searches_Television(String TV) {
	   tn = TV;
	   WebElement search = Hooks.driver.findElement(By.name("q"));
	   search.sendKeys(tn,Keys.ENTER);
	}
}
