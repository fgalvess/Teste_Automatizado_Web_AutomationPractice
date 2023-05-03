package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoPage {

	@FindBy(xpath = "(//span[text()[contains(.,\"Proceed\")]])[2]")
	private WebElement checkoutDois;

	@FindBy(xpath = "//*[@class=\"fancybox-item fancybox-close\"]")
	private WebElement botaoClose;

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@title=\"Pay by bank wire\"]")
	private WebElement pagamento;

	@FindBy(xpath = "//span[text()[contains(.,\"I confirm my order\")]]")
	private WebElement confirmar;

	public void realizarCheckout() {
		for (int i = 0; i < 3; i++) {
			checkoutDois.click();
		}
	}

	public void fecharAvisoDeTermos() {
		botaoClose.click();
	}

	public void realizarCheckouEAceitarTermos() {
		for (int i = 0; i < 2; i++) {
			checkoutDois.click();
		}
		checkBox.click();
		checkoutDois.click();
	}

	public void escolherFormaDePagamento() {
		pagamento.click();
	}

	public void confirmarPedido() {
		confirmar.click();
	}
}
