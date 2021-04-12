package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lib.ConfigReader;

public class SwagLabs {
	
	WebDriver driver;
	ConfigReader config;
	
	@BeforeTest
	public void setup() {
		
		config =new ConfigReader();
		System.setProperty("webdriver.chrome.driver",config.getchromepath());
		driver= new ChromeDriver();	
	}
	
	@Test
	public void login() { 
		
		driver.get(config.getURL());
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed());
		System.out.println("<======Verified Page====>");	
	}
	
	@AfterTest
	public void quit() {
		
	driver.quit();
		
		
	}
	
}
