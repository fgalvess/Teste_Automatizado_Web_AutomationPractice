package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelaInicialPage {

	@FindBy(xpath = "//a[@Class='login']")
	private WebElement signIn;
	
	public void clicarSignIn() {
		signIn.click();
	}
}

