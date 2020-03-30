package login;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Login_test {
	  WebDriver driver =new ChromeDriver();
	  ExtentTest test;
	  ExtentReports reports;
	  
  @Test
  
  public void Valid() {
	   
	  ExtentReports reports = new ExtentReports("D:\\New Reports\\All_Login_Funcionality.html",false);
	  test = reports.startTest("Login_test");
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Test\\chromedriver.exe");
	  driver.manage().window().maximize();
		
	  	  //Open First tab for Invalid credential		
	  	  test.log(LogStatus.INFO,"Open First tab for Invalid credential");
	  	  
		  driver.get("https://qdsignage.com/digital_signage/webservices/AdminLogin/Login"); //write your domain 
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//*[@id=\"loginAdmin\"]/div[1]/input")).sendKeys("admin.qdsignage@gmail.com"); 
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456");
		  driver.findElement(By.xpath("//input[contains(@class,'login100-form-btn')]")).click();
		  
				  if(driver.getTitle().equalsIgnoreCase("Online Status"))
				  {
					  
					  	System.out.println("Login successfully with correct credential");
					  	test.log(LogStatus.PASS,"Login successfully with correct credential");
				  }
				  else
				  {
					  	System.out.println("Login Unsuccessfully with correct credential");
					  	test.log(LogStatus.FAIL,"Login Unsuccessfully with correct credential");
				  }
		 
		  driver.findElement(By.className("report_logout_btn")).click();
		  
		  
		  //Open second tab for Invalid credential
		  test.log(LogStatus.INFO,"Open second tab for Invalid credential");
		  
		  ((JavascriptExecutor)driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		  driver.get("https://qdsignage.com/digital_signage/webservices/AdminLogin/Login");
		  
		 
		  driver.findElement(By.xpath("//*[@id=\"loginAdmin\"]/div[1]/input")).sendKeys("admin.qsignage@gmail.com"); 
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("12456");
		  driver.findElement(By.xpath("//input[contains(@class,'login100-form-btn')]")).click();
		  
		  
				  if(driver.getTitle().equalsIgnoreCase("Online Status"))
				  {
					  
					  	System.out.println("Pass to login with invalid credentials");
					  	test.log(LogStatus.FAIL,"Pass to login with invalid credentials");
				  }
				  else
				  {
					  	System.out.println("Fail to login with invalid credentials");
					  	test.log(LogStatus.PASS,"Fail to login with invalid credentials");
				  }
		  
		  
		  //Open Third tab for Invalid PSW	
		  test.log(LogStatus.INFO,"Open Third tab for Invalid Password");
		  
		  ((JavascriptExecutor)driver).executeScript("window.open()");
		  ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs3.get(2));
		  driver.get("https://qdsignage.com/digital_signage/webservices/AdminLogin/Login");
		  
		 
		  driver.findElement(By.xpath("//*[@id=\"loginAdmin\"]/div[1]/input")).sendKeys("admin.qdsignage@gmail.com"); 
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("12456");
		  driver.findElement(By.xpath("//input[contains(@class,'login100-form-btn')]")).click();
		  
		  
				  if(driver.getTitle().equalsIgnoreCase("Online Status"))
				  {
					  
					  	System.out.println("Login success with right username but wrong Password.");
					  	test.log(LogStatus.FAIL,"Login success with right username but wrong Password.");
				  }
				  else
				  {
					  	System.out.println("Fail to login with right username but wrong Password.");
					  	test.log(LogStatus.PASS,"Fail to login with right username but wrong Password.");
				  }
		  
		  
		  
		//Open fourth tab for Invalid username but right password
		  test.log(LogStatus.INFO,"Open fourth tab for Invalid username but right password");
		  
		  ((JavascriptExecutor)driver).executeScript("window.open()");
		  ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs4.get(3));
		  driver.get("https://qdsignage.com/digital_signage/webservices/AdminLogin/Login");
		  
		 
		  driver.findElement(By.xpath("//*[@id=\"loginAdmin\"]/div[1]/input")).sendKeys("admin.qdsignge@gmail.com"); 
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456");
		  driver.findElement(By.xpath("//input[contains(@class,'login100-form-btn')]")).click();
		  
		  
				  if(driver.getTitle().equalsIgnoreCase("Online Status"))
				  {
					  
					  	System.out.println("Login success Invalid username but right password.");
					  	test.log(LogStatus.FAIL,"Login success Invalid username but right password.");
				  }
				  else
				  {
					  	System.out.println("Fail to login with Invalid username but right password");
					  	test.log(LogStatus.PASS,"Fail to login with invalid credentials");
				  }
		  
		  
		//Open five tab for valid username but right password with multiple spaces
		  test.log(LogStatus.INFO,"Open five tab for valid username but right password with multiple spaces");  
		  
		  ((JavascriptExecutor)driver).executeScript("window.open()");
		  ArrayList<String> tabs5 = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs5.get(4));
		  driver.get("https://qdsignage.com/digital_signage/webservices/AdminLogin/Login");
		  
		 
		  driver.findElement(By.xpath("//*[@id=\"loginAdmin\"]/div[1]/input")).sendKeys("admin.qdsignage@gmail.com         "); 
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("12456      ");
		  driver.findElement(By.xpath("//input[contains(@class,'login100-form-btn')]")).click();
		  
		  
				  if(driver.getTitle().equalsIgnoreCase("Online Status"))
				  {
					  
					  	System.out.println("Login success with valid username but right password with multiple spaces.");
					  	test.log(LogStatus.FAIL,"Login success with valid username but right password with multiple spaces.");
				  }
				  else
				  {
					  	System.out.println("Fail to login with valid username but right password with multiple spaces.");
					  	test.log(LogStatus.PASS,"Fail to login with valid username but right password with multiple spaces.");
				  }
		  
		  reports.endTest(test); 
		  reports.flush();
  }

  }
