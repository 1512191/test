package lazada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {
	private WebDriver driver;
	private int timeout=15;
	public RegisterPage(){
		
	}
	public RegisterPage(WebDriver driver){
		this();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public RegisterPage(WebDriver driver, int timeout){
		this();
		this.driver=driver;
		this.timeout=timeout;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/input")
	private WebElement number_phone;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/span")
	private WebElement message_number_phone;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]")
	private WebElement btn_send_code;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[3]/div[1]/input")
	private WebElement number_code;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[3]/div[2]/span")
	private WebElement message_code;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[1]/input")
	private WebElement username;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/span")
	private WebElement message_username;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[5]/div[1]/input")
	private WebElement password;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[5]/div[2]/span")
	private WebElement message_password;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[6]/div[1]/input")
	private WebElement confirm_password;
	@FindBy(xpath="//*[@id=\'modal\']/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[6]/div[1]/input")
	private WebElement message_confirm_password;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[7]/div[1]/div/div[1]/input")
	private WebElement capcha;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[7]/div[1]/div/div[2]/span")
	private WebElement message_capcha;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[2]/div/button[1]")
	private WebElement goback;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[2]/div/button[2]")
	private WebElement btn_register;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[8]/span[2]")
	private WebElement navigate_terms;
	@FindBy(xpath="//*[@id=\"modal\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[8]/span[3]")
	private WebElement navigate_security;
	//action
	public void sendNumberPhone(String number) throws Exception{
		
		this.number_phone.sendKeys(number);
	}
	public void sendNumberCode(String number) throws Exception{
		
		this.number_code.sendKeys(number);
	}
	public void sendUsername(String username) throws Exception{
		
		this.username.sendKeys(username);
	}
	public void sendPassword(String password)throws Exception{
		
		this.password.sendKeys(password);
	}
	public void sendConfirmPassword(String confirm_password)throws Exception{
		
		this.confirm_password.sendKeys(confirm_password);
	}
	public void sendCapcha(String capcha) throws Exception{
		this.capcha.sendKeys(capcha);
	}
	public String getPassword() {
		return this.password.getText();
	}
	public String getConfirmPassword() {
		return this.confirm_password.getText();
	}
	public void clearInput() {
		this.number_phone.clear();
		this.number_code.clear();
		this.username.clear();
		this.password.clear();
		this.confirm_password.clear();
		this.capcha.clear();
	}
	public void navigateToTerms() {
		this.navigate_terms.click();
	}
	public void navigateToSecurity() {
		this.navigate_security.click();
	}
	public void clickRegister() {
		this.btn_register.click();
	}
	public void setRegister(String phone, String code, String username, String password, String confirm_password, String capcha) throws Exception{
		this.sendNumberPhone(phone);
		this.sendNumberCode(code);
		this.sendUsername(username);
		this.sendPassword(password);
		this.sendConfirmPassword(confirm_password);
		this.sendCapcha(capcha);
		this.btn_register.click();
	}
	public String getMessagePhone() {
		return this.message_number_phone.getText();
	}
	public String getMessageCode() {
		return this.message_code.getText();
	}
	public String getMessageUsername() {
		return this.message_username.getText();
	}
	public String getMessagePassword() {
		return this.message_password.getText();
	}
	public String getMessageCapcha() {
		return this.message_capcha.getText();
	}
	public String getMessageConfirmPassword() {
		return this.message_confirm_password.getText();
	}
	//verify
	public boolean verifyPassword() {
		if(this.getPassword().equals(this.getConfirmPassword())) return true;
		else return false;
	}
	
	public boolean verifyResult(String expected_result, String actual_result) {
		boolean result;
		if(expected_result.contentEquals(actual_result)) {
			result = true;
		}else result = false;
		return result;
	}
}
