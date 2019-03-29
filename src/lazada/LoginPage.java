package lazada;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;
	private int timeout=15;
	public LoginPage(){
		
	}
	public LoginPage(WebDriver driver){
		this();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public LoginPage(WebDriver driver, int timeout){
		this();
		this.driver = driver;
		this.timeout = timeout;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[1]/input")
	WebElement username;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[2]/input")
	WebElement password;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[2]/div[1]/button")
	WebElement btnLogin;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[3]/a")
	WebElement toFogotPassword;
	@FindBy (xpath="//*[@id='container']/div/div[1]/div/span/a")
	WebElement toRegister;
	@FindBy (xpath="//*[@id='container']/div/div[2]/form/div/div[2]/div[2]/div/div[2]/button[1]")
	WebElement btnLoginFacebook;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[2]/div[2]/div/div[2]/button[2]")
	WebElement btnLoginGoogle;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[1]/span")
	WebElement messageUser;
	@FindBy(xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[2]/span")
	WebElement messagePass;
	@FindBy(xpath="//*[@id='nc_2_n1z']")
	WebElement btnSlide;
	//action
	public RegisterPage navigateToRegister()throws Exception{
		toRegister.click();
		return new RegisterPage(driver, timeout);
	}
	public FogotPasswordPage navigateToFogotPassword()throws Exception{
		toFogotPassword.click();
		return new FogotPasswordPage(driver, timeout);
	}
	public void sendUsername(String key)throws Exception{
		username.sendKeys(key);
	}
	public void sendPassword(String pass)throws Exception{
		password.sendKeys(pass);
	}
	public void clickLogin() throws Exception{//*[@id="nc_68__scale_text"]/span
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		long start_time = System.currentTimeMillis();	
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btnSlide));
		Actions builders = new Actions(driver);
		Point point = btnSlide.getLocation();
		int x = point.getX();
		int y = point.getY();
		 Thread.sleep(10000);
		Action pullSlide = builders.dragAndDropBy(btnSlide, x + 265, y).build();
		pullSlide.perform();
		
		js.executeScript("return document.readyState");
	        Thread.sleep(10000);
			
			
		
		
	}
	public void clickLoginFacebook() throws Exception{
		btnLoginFacebook.click();
	}
	public void clickLoginGoogle() throws Exception{
		btnLoginGoogle.click();
	}
	public String getMessageUser()throws Exception{
		return messageUser.getText();
	}
	public String getMessagePass()throws Exception{
		return messagePass.getText();
	}
	//verify
	public void verifyLogin(String expectedResult)throws Exception{
		String messageUserActual = this.getMessageUser();
		String messagePassActual = this.getMessagePass();
		boolean result1 = messageUserActual.contains(expectedResult);
		boolean result2 = messagePassActual.contains(expectedResult);
		Assert.assertTrue(result2 && result1 , "Pass");
	}
	public void verifyLoginUsername(String expectedResult, String messageActual)throws Exception{
//		String messageUserActual = this.getMessageUser();
		
		boolean result = messageActual.contains(expectedResult);
		
		Assert.assertTrue(result , "Pass");
	}
}
