package lazada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FogotPasswordPage {
	private WebDriver driver;
	private int timeout=15;
	public FogotPasswordPage(){
		
	}
	public FogotPasswordPage(WebDriver driver){
		this();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public FogotPasswordPage(WebDriver driver, int timeout){
		this();
		this.driver = driver;
		this.timeout=timeout;
		PageFactory.initElements(driver, this);
	}
}
