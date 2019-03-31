package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lazada.RegisterPage;

public class RegisterTest {

	
		private WebDriver driver;
		private int timeout =30;
		RegisterPage obj;
		@BeforeSuite
		public void TestSuite(){
			System.out.println("Function register");
		}
		@BeforeTest
		public void setUp() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\test\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			String url = "https://shopee.vn/";
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			By advertisement = By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div");
			WebElement btnClose = driver.findElement(advertisement);
			btnClose.click();
			Thread.sleep(5000);
			By btnRegister = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div[1]/div/ul/li[3]");
			WebElement navigateRegister = driver.findElement(btnRegister);
			navigateRegister.click();
			obj = new RegisterPage(driver, timeout);
		}
		@Test()
		public void submitWithInputEmpty() throws Exception{
			
			obj.clearInput();
			obj.clickRegister();
			Thread.sleep(5000);
			boolean res1 = obj.verifyResult("Số điện thoại không hợp lệ", obj.getMessagePhone());
			boolean res2 = obj.verifyResult("Mã xác minh phải gồm 6 chữ số", obj.getMessageCode());
			boolean res3 = obj.verifyResult("Vui lòng nhập Tên người dùng", obj.getMessageUsername());
			boolean res4 = obj.verifyResult("Mật khẩu phải dài từ 8-16 kí tự, bao gồm 1 chữ viết hoa và 1 chữ viết thường",obj.getMessagePassword());
			boolean res5 = obj.verifyResult("Mã capcha không được để trống", obj.getMessageCapcha());
			Assert.assertTrue(res1 && res2 && res3 && res4 && res5);
		}
//		@Test()
//		public void submitWithEmptyUsernameInput()throws Exception{
//			Thread.sleep(5000);
//			obj.clearInput();
//			Thread.sleep(5000);
//			obj.sendPassword("thanhhue97");
//			
//			obj.clickLogin();
//			obj.verifyLoginUsername("You can't leave this empty.", obj.getMessageUser());
//		}
//		@Test()
//		public void submitWithEmptyPasswordInput()throws Exception{
//			Thread.sleep(5000);
//			obj.clearInput();
//			Thread.sleep(5000);
//			obj.sendUsername("0963101858");
//			obj.clickLogin();
//			obj.verifyLoginUsername("You can't leave this empty.", obj.getMessagePass());
//		}
//		@Test
//		public void submitWithInputUserIsWord()throws Exception{
//			obj.clearInput();
//			obj.sendUsername("thanhhue");
//			obj.sendPassword("thanhhue97");
//			Thread.sleep(5000);
//			obj.clickLogin();
////			obj.verifyLoginUsername("You can't leave this empty.", obj.getMessagePass());
//		}
		@AfterTest
		public void close(){
			driver.close();
			
		}
	}


