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

public class EmployeeTest {
	static public WebDriver driver;;

	@BeforeMethod
	public void beforeMethod() {
		String url = "http://localhost:8888/staff/insert?";
		driver.get(url);
		System.out.println("đã vào beforemethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("đã vào aftermethod");
	}

	@BeforeTest
	public static void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Tester\\Chromedriver\\chromedriver.exe");
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

	@Test(description = "Empty Fullname", groups = "groupTest", priority = 1)
	public void Staff11() {
		try {
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("fullnameerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Nhap");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty Image", groups = "groupTest", priority = 1)
	public void Staff12() {
		try {
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("photoerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Chon anh");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty E", groups = "groupTest", priority = 1)
	public void Staff13() {
		try {
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("emailerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Nhap Email va dung dinh dang");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty note", groups = "groupTest", priority = 1)
	public void Staff14() {
		try {
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("noteerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Nhap ghi chu di");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff15() {
		try {
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("phoneerror"));
			String actual = invalidDiv.getText();
			assertEquals(actual, "Nhap so va phai 10 chu so");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff16() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("012365478");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			System.out.println(phone.getText().length());
			assertEquals(phone.getText().length(), 9);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff17() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("01236547");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 8);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff19() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("0123654");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 7);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff20() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("012365");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 6);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff21() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("01236");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 5);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff22() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("0123");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 4);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff23() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("0123");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 4);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff24() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("012");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 3);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff25() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("01");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 2);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}

	@Test(description = "Empty phone", groups = "groupTest", priority = 1)
	public void Staff26() {
		try {
			WebElement phone = driver.findElement(By.id("phone"));
			phone.sendKeys("0");
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			Thread.sleep(1000);
			assertEquals(phone.getAttribute("value").length(), 1);
		} catch (Exception e) {
			fail("Lỗi: Khong nhap ma hop le");
		}
	}
	
	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectListStaff() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement addStaffButton = driver.findElement(By.id("exit"));
			addStaffButton.click();
			
			
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/staff/listStaff");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}

	@Test(description = "Empty Username", groups = "groupTest", priority = 1)
	public void rediectInsertStaff() {
		try {
			
			System.out.println(driver.getCurrentUrl());
			
			WebElement addStaffButton = driver.findElement(By.id("insert"));
			addStaffButton.click();
			
			System.out.println(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), "http://localhost:8888/staff/insert?");
			
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	
}
