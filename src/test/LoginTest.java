package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import page.LoginPage;



//Hello I am KamalPreet jhinjher

public class LoginTest {
public WebDriver driver;
static
{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}

@Test(priority=1)
public void open_the_LoginPage_Url() throws InterruptedException
{
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
driver.get("https://uat2.app.shipcaddie.com/login");
Thread.sleep(10000);
}

@Test(priority=2)
public void enter_valid_username_and_invalid_password() throws InterruptedException
{
//create an object for class LoginPage
LoginPage login=new LoginPage(driver);
//enter user name
login.email("nandnakumar@csgroupchd.com");
//enter password
login.password("test123");
//clicking on login button
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=3)
public void enter_invalid_username_and_valid_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("test@yopmail.com");
login.password("Nandankumar1");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=4)
public void enter_valid_username_and_empty_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("nandankumar@csgroupchd.com");
login.password("");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=5)
public void enter_invalid_username_and_empty_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("test@yopmail.com");
login.password("");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=6)
public void enter_empty_username_and_valid_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("");
login.password("Nandankumar1");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=7)
public void enter_empty_username_and_invalid_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("");
login.password("test123");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=8)
public void enter_empty_username_and_empty_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("");
login.password("");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=9)
public void enter_invalid_username_and_invalid_password() throws InterruptedException
{
LoginPage login=new LoginPage(driver);
login.email("test@yopmail.com");
login.password("test123");
login.signin();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(1000);
}

@Test(priority=10)
public void enter_valid_username_and_valid_password() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
{
	String path="./password/input.xls";
	Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	String email = wb.getSheet("id").getRow(0).getCell(0).toString(); 
	String password = wb.getSheet("id").getRow(1).getCell(0).toString();
//	String bodyRequest = wb.getSheet("body").getRow(0).getCell(0).toString();
//	String Tokenkey = wb.getSheet("Tokenkey").getRow(0).getCell(0).toString();
//	String TokenValue= wb.getSheet("TokenValue").getRow(0).getCell(0).toString();
LoginPage login=new LoginPage(driver);
login.email(email);
login.password(password);
login.signin();
Thread.sleep(1000);
}

@Test(priority=11)
public void enter_valid_username_and_invalid_password1()
{
	LoginPage login=new LoginPage(driver);
	login.email("nandankumar@csgroupchd.com");
	login.password("nandankumar1");
	login.signin();
}
}
