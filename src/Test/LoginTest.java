package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lazada.LoginPage;

public class LoginTest {
	private WebDriver driver;
	private int timeout =15;
	LoginPage obj;
	@BeforeSuite
	public void TestSuite(){
		System.out.println("Function login");
	}
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dtthue\\workspace\\lazada\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.lazada.vn/";
		driver.get(url);
		By btnLogin = By.xpath("//*[@id='anonLogin']/a");
		WebElement navigateLogin = driver.findElement(btnLogin);
		navigateLogin.click();
		obj = new LoginPage(driver, timeout);
	}
	@Test(enabled = false)
	public void submitWithInputEmpty() throws Exception{
		Thread.sleep(5000);
		obj.clickLogin();
		
		obj.verifyLogin("You can't leave this empty.");
	}
	@Test(enabled = false)
	public void submitWithEmptyUsernameInput()throws Exception{
		obj.sendPassword("thanhhue97");
		Thread.sleep(5000);
		obj.clickLogin();
		obj.verifyLoginUsername("You can't leave this empty.", obj.getMessageUser());
	}
	@Test(enabled = false)
	public void submitWithEmptyPasswordInput()throws Exception{
		obj.sendUsername("0963101858");
		Thread.sleep(5000);
		obj.clickLogin();
		obj.verifyLoginUsername("You can't leave this empty.", obj.getMessagePass());
	}
	@Test
	public void submitWithInputUserIsWord()throws Exception{
		obj.sendUsername("thanhhue");
		obj.sendPassword("thanhhue97");
		Thread.sleep(5000);
		obj.clickLogin();
		obj.verifyLoginUsername("You can't leave this empty.", obj.getMessagePass());
	}
//	@AfterTest
//	public void close(){
//		if(driver != null){
//			driver.close();
//		}
//		
//	}
}
