package stepsDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.*;
import org.openqa.selenium.By;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.CadastroPage;
import pageObjects.CarrinhoPage;
import pageObjects.TelaInicialPage;
import pageObjects.TelaPrincipalPage;

public class ComprasSteps {

	/*
	 * OBS: O c�digo da erro ao tentar rodar com a vers�o atual do chrome (103) e ao
	 * pesquisar descobri que � bug da nova vers�o do chrome com o selenium e a
	 * unica solu��o que achei foi rodar meus testes na vers�o anterior do chrome
	 * (102)
	 */

	@Dado("que eu cliquei em sign in")
	public void queEuCliqueiEmSignIn() {
		Na(TelaInicialPage.class).clicarSignIn();
	}

	@Quando("informar no campo email {string}")
	public void informarNoCampoEmail(String email) {
		Na(CadastroPage.class).informarEmail(email);
	}

	@Quando("clicar em create an account")
	public void clicarEmCreateAnAccount() {
		Na(CadastroPage.class).acionarBotaoCriar();
	}

	@Entao("o sistema exibe mensagem de email invalido")
	public void oSistemaExibeMensagemDeEmailInvalido() {
		assertEquals("Invalid email address.",
				driver.findElement(By.xpath("//li[text()[contains(.,\"Invalid email\")]]")).getText());
	}

	@Dado("que eu esteja na tela de cadastro")
	public void queEuEstejaNaTelaDeCadastro() {
		Na(TelaInicialPage.class).clicarSignIn();
		Na(CadastroPage.class).criarConta();
	}

	@Quando("eu preencher o campo zip\\/postal")
	public void euPreencherOCampoZipPostal() {
		Na(CadastroPage.class).preencherPostalCode();
	}

	@Quando("eu clicar em registrar")
	public void euClicarEmRegistrar() {
		Na(CadastroPage.class).acionarBotaoRegistrar();
	}

	@Entao("o sistema exibe a mensagem dos campos obrigatorios")
	public void oSistemaExibeAMensagemDosCamposObrigatorios() {
		assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).isDisplayed());
		assertEquals("The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
				driver.findElement(By.xpath("\r\n" + "//*[text()[contains(.,\"It must follow this format: 00000\")]]"))
						.getText());
	}

	@Dado("que eu esteja logado")
	public void queEuEstejaLogado() {
		Na(TelaInicialPage.class).clicarSignIn();
		Na(CadastroPage.class).logar();
	}

	@Quando("eu pesquisar um produto")
	public void euPesquisarUmProduto() {
		Na(TelaPrincipalPage.class).pesquisarProduto();
	}

	@Entao("o sistema exibe a quantidade de resultados relacionado a pesquisa")
	public void oSistemaExibeAQuantidadeDeResultadosRelacionadoAPesquisa() {
		assertEquals("1 result has been found.",
				driver.findElement(By.xpath("//span[text()[contains(.,\"1 result has been found\")]]")).getText());
	}

	@Dado("que eu esteja na tela principal")
	public void queEuEstejaNaTelaPrincipal() {
		Na(TelaInicialPage.class).clicarSignIn();
		Na(CadastroPage.class).logar();
	}

	@Quando("eu adicionar dois produtos ao carrinho")
	public void euAdicionarDoisProdutosAoCarrinho() {
		Na(TelaPrincipalPage.class).adicionarProdutos();
	}

	@Quando("eu remover um produto")
	public void euRemoverUmProduto() {
		Na(TelaPrincipalPage.class).removerUmProduto();
	}

	@Entao("o sistema exibe o carrinho com apenas um produto")
	public void oSistemaExibeOCarrinhoComApenasUmProduto() {
		assertEquals("1",
				driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]/span[text()=\"1\"]")).getText());
	}

	@Dado("que eu esteja na tela do carrinho de compras")
	public void queEuEstejaNaTelaDoCarrinhoDeCompras() {
		Na(TelaInicialPage.class).clicarSignIn();
		Na(CadastroPage.class).logar();
		Na(TelaPrincipalPage.class).adicionarParaCheckout();
	}

	@Quando("eu fizer o checkout")
	public void euFizerOCheckout() {
		Na(CarrinhoPage.class).realizarCheckout();
	}

	@Entao("o sistema exibe mensagem para concordar com os termos de servico")
	public void oSistemaExibeMensagemParaConcordarComOsTermosDeServico() {
		assertTrue(driver.findElement(By.xpath("//*[@class=\"fancybox-error\"]")).isDisplayed());
		Na(CarrinhoPage.class).fecharAvisoDeTermos();
		assertTrue(driver.findElement(By.xpath("//*[@class=\"iframe\"]")).isDisplayed());
	}

	@Dado("que eu loguei no sistema")
	public void queEuEstejaLogueiNoSistema() {
		Na(TelaInicialPage.class).clicarSignIn();
		Na(CadastroPage.class).logar();
	}

	@Quando("eu adicionar um produto ao carrinho")
	public void euAdicionarUmProdutoAoCarrinho() {
		Na(TelaPrincipalPage.class).adicionarParaCheckout();
	}

	@Quando("eu fiz o checkout")
	public void euFizOCheckout() {
		Na(CarrinhoPage.class).realizarCheckouEAceitarTermos();
	}

	@Quando("eu escolher a forma de pagamento")
	public void euEscolherAFormaDePagamento() {
		Na(CarrinhoPage.class).escolherFormaDePagamento();
	}

	@Quando("eu confirmar meu pedido")
	public void euConfirmarMeuPedido() {
		Na(CarrinhoPage.class).confirmarPedido();
	}

	@Entao("o sistema exibe a confirmacao do pedido")
	public void oSistemaExibeAConfirmacaoDoPedido() {
		assertEquals("ORDER CONFIRMATION",
				driver.findElement(By.xpath("//h1[text()[contains(.,\"Order confirmation\")]]")).getText());
	}
}
