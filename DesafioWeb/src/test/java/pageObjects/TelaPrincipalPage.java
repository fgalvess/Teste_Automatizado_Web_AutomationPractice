package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import static utils.Utils.*;

public class TelaPrincipalPage {
	
	Actions acao = new Actions(driver);

	@FindBy(id = "search_query_top")
	private WebElement campoPesquisar;
	
	@FindBy(xpath = "//button[@name=\"submit_search\"]")
	private WebElement botaoPesquisar;
	
	@FindBy(xpath = "//div[@class=\"product-image-container\"]")
	private WebElement produtoUm;
	
	@FindBy(xpath = "//a[@class=\"product_img_link\"]")
	private WebElement produtoDois;
	
	@FindBy(xpath = "//span[text()[contains(.,\"Add to cart\")]]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//span[text()[contains(.,\"Continue shopping\")]]")
	private WebElement continueComprando;
	
	@FindBy(xpath = "//span[@class=\"cross\"]")
	private WebElement fechar;
	
	@FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
	private WebElement carrinho;
	
	@FindBy(xpath = "//a[@class=\"ajax_cart_block_remove_link\"]")
	private WebElement excluirProduto;
	
	@FindBy(xpath = "//span[text()[contains(.,\"Proceed to checkout\")]]")
	private WebElement checkoutUm;

	
	public void pesquisarProduto() {
		campoPesquisar.sendKeys("shirt");
		botaoPesquisar.click();
	}
	
	public void adicionarProdutos() {
		campoPesquisar.sendKeys("shirt");
		botaoPesquisar.click();
		acao.moveToElement(produtoUm).build().perform();
		acao.moveToElement(addToCart).click().build().perform();
		continueComprando.click();
		campoPesquisar.clear();
		campoPesquisar.sendKeys("blouses");
		botaoPesquisar.click();
		acao.moveToElement(produtoDois).build().perform();
		acao.moveToElement(addToCart).click().build().perform();
		fechar.click();	
	}
	
	public void removerUmProduto() {
		fechar.click();
		acao.moveToElement(carrinho).build().perform();
		acao.moveToElement(excluirProduto).click().build().perform();
	}
	
	public void adicionarParaCheckout() {
		campoPesquisar.sendKeys("shirt");
		botaoPesquisar.click();
		acao.moveToElement(produtoUm).build().perform();
		acao.moveToElement(addToCart).click().build().perform();
		checkoutUm.click();
	}
	
}

