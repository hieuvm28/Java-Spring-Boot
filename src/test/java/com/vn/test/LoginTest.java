package com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	static public WebDriver driver;
	
	@BeforeMethod	
	public void beforeMethod()  {
	String url = "http://localhost:8888/login";
		driver.get(url);
		System.out.println("đã vào beforemethod");
	}

	@AfterMethod
	public void afterMethod() {	
		System.out.println("đã vào aftermethod");
	}

	@BeforeTest
	public static void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Tester\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public static void afterTest() {
		driver.close();
	}
	
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void emptyUsername() {
		try {
			WebElement login = driver.findElement(By.id("login"));
			login.click();
			WebElement invalidDiv = driver.findElement(By.id("usernameerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Empty Username");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void emptyPassword() {
		try {
			WebElement login = driver.findElement(By.id("login"));
			login.click();
			WebElement invalidDiv = driver.findElement(By.id("passworderror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Empty Password");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectAdmin() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement UsernameFied = driver.findElement(By.id("username"));
			UsernameFied.sendKeys("hieuvm28");
			WebElement PasswordFied = driver.findElement(By.id("password"));
			PasswordFied.sendKeys("hieuvm28");
			WebElement login = driver.findElement(By.id("login"));
			login.click();
			
			String url1 = "http://localhost:8888/admin";
			driver.get(url1);
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), url1);
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
}
