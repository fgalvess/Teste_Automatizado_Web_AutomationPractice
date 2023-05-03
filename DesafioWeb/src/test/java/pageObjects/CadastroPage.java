package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utils.Utils.*;;

public class CadastroPage {

	@FindBy(id = "email_create")
	private WebElement campoEmail;

	@FindBy(id = "SubmitCreate")
	private WebElement botaoCriar;

	@FindBy(id = "postcode")
	private WebElement zipPostal;

	@FindBy(id = "submitAccount")
	private WebElement botaoRegistrar;

	@FindBy(id = "email")
	private WebElement emailLogin;

	@FindBy(id = "passwd")
	private WebElement senhaLogin;

	@FindBy(id = "SubmitLogin")
	private WebElement signinLogin;

	public void informarEmail(String email) {
		campoEmail.sendKeys(email);
	}

	public void acionarBotaoCriar() {
		botaoCriar.click();
	}

	public void criarConta() {
		campoEmail.sendKeys("samuel@colt.com");
		botaoCriar.click();
	}

	public void preencherPostalCode() {
		zipPostal.sendKeys("00000000");
	}

	public void acionarBotaoRegistrar() {
		sleep();
		botaoRegistrar.click();
	}

	public void logar() {
		emailLogin.sendKeys("dean@whinchester.com");
		senhaLogin.sendKeys("senha");
		signinLogin.click();
	}
}
