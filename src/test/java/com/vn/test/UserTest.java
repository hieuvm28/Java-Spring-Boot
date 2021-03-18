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

public class UserTest {
		
	 static public WebDriver driver;;

		@BeforeMethod	
		public void beforeMethod()  {
			String url = "http://localhost:8888/user/insertUser?";
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
		public void User01() {
			try {
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("usernameerror"));
				String actual = invalidDiv.getText();
				assertEquals(actual, "Không được để trống Username");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		
		
		@Test(description = "Check trung username", groups = "groupTest", priority = 1)
		public void User02() {
			
			try {
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("hieuvm28");
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("usernameerror"));
				String actual = invalidDiv.getText();
				assertEquals(actual, "Đã tồn tại username");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
  
		
		@Test(description = "Check Title", groups = "groupTest", priority = 1)
		public void User03() {
			try {
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				Thread.sleep(1000);
				String actual = driver.getTitle();
				assertEquals(actual, "Inser User");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
  
  
		@Test(description = "Empty Password", groups = "groupTest", priority = 1)
		public void User04() {
			try {
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("passworderror"));
				String actual = invalidDiv.getText();
				assertEquals(actual, "Không được để trống Password");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		

		@Test(description = "Empty Fullname", groups = "groupTest", priority = 1)
		public void User05() {
			try {
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("fullnameerror"));
				String actual = invalidDiv.getText();
				assertEquals(actual, "Không được để trống tên");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		By username = By.id("username");
		By submit = By.id("insert");
		
		@Test(description = "Nhập mã nhân viên với chữ hoa không dấu và số", groups = "groupTest", priority = 8)
		public void User06() {
			try {
				driver.findElement(username).sendKeys("ABCD123");
				driver.findElement(submit).click();
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("usernameerror"));
				String actual = invalidDiv.getText();
				assertEquals(actual, "");
				
			} catch (Exception e) {
				fail("Lỗi : Không nhập mã hợp lệ");
			}
		}

		@Test(description = "Check username have 9 length", groups = "groupTest", priority = 15)
		public void User07() {
			try {
				driver.findElement(username).sendKeys("hhhhhhhhh");
				driver.findElement(submit).click();
				Thread.sleep(1000);
				WebElement ok = driver.findElement(username);
				assertEquals(ok.getAttribute("value").length(), 9);
			} catch (Exception e) {
				fail("Lỗi : Không nhập mã hợp lệ");
			}
		}
		
		@Test(description = "Check fullname with number", groups = "groupTest", priority = 15)
		public void User08() {
			try {
				driver.findElement(username).sendKeys("Hieu 123");
				driver.findElement(submit).click();
				Thread.sleep(1000);
				WebElement ok = driver.findElement(By.id("usernameerror"));
				assertEquals(ok, "");
			} catch (Exception e) {
				fail("Lỗi : Không nhập mã hợp lệ");
			}
		}
		
		@Test(description = "Username with 1 char", groups = "groupTest", priority = 13)
		public void User09() {
			try {
				driver.findElement(username).sendKeys("h");
				driver.findElement(submit).click();
				Thread.sleep(1000);
				WebElement ok = driver.findElement(By.id("username"));
				int actual = ok.getAttribute("value").length();
				assertEquals(actual, 1);
			} catch (Exception e) {
				fail("Lỗi : Không nhập mã hợp lệ");
			}
		}
		
		@Test(description = "Username with 2 char", groups = "groupTest", priority = 14)
		public void User10() {
			try {
				driver.findElement(username).sendKeys("hh");
				driver.findElement(submit).click();
				Thread.sleep(1000);
				assertEquals(driver.findElement(username).getAttribute("value").length(), 2);
			} catch (Exception e) {
				fail("Lỗi : Không nhập mã hợp lệ");
			}
		}
		
		@Test(description = "Empty Username", groups = "groupTest", priority = 1)
		public void rediectListtUser() {
			try {
				
				System.out.println(driver.getCurrentUrl());
				
				WebElement addStaffButton = driver.findElement(By.id("listUser"));
				addStaffButton.click();
				
				System.out.println(driver.getCurrentUrl());
				assertEquals(driver.getCurrentUrl(), "http://localhost:8888/user/");
				
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Empty Username", groups = "groupTest", priority = 1)
		public void rediectInsertUser() {
			try {
				
				System.out.println(driver.getCurrentUrl());
				
				WebElement addStaffButton = driver.findElement(By.id("insert"));
				addStaffButton.click();
				
				System.out.println(driver.getCurrentUrl());
				assertEquals(driver.getCurrentUrl(), "http://localhost:8888/user/insertUser?");
				
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

}
