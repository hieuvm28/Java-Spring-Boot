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

public class AdminTest {
	static public WebDriver driver;;

	@BeforeMethod	
	public void beforeMethod()  {
		String url = "http://localhost:8888/admin";
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
		String url = "http://localhost:8888/login";
		driver.get(url);
		WebElement UsernameFied = driver.findElement(By.id("username"));
		UsernameFied.sendKeys("hieuvm28");
		WebElement PasswordFied = driver.findElement(By.id("password"));
		PasswordFied.sendKeys("hieuvm28");
		WebElement LoginButun = driver.findElement(By.id("login"));
		LoginButun.click();
	}

	@AfterTest
	public static void afterTest() {
		driver.close();
	}
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectUser() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement button = driver.findElement(By.id("user"));
			button.click();
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/user/");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectDepart() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement button = driver.findElement(By.id("depart"));
			button.click();
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/depart/listDepart");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectStaff() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement button = driver.findElement(By.id("staff"));
			button.click();
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://lo"
					+ "calhost:8888/staff/listStaff");
			
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectRecord() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement button = driver.findElement(By.id("record"));
			button.click();
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/record/listRecord");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectSummarize() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement button = driver.findElement(By.id("summarize"));
			button.click();
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/summarize");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
}
