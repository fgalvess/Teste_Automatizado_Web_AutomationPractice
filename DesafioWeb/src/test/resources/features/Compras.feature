#language: pt
#encoding: UTF-8

Funcionalidade: Realizar compras
eu como cliente
quero criar uma conta no site
para realizar a compra de um ou mais itens

@emailInvalido
Cenario: email invalido
Dado que eu cliquei em sign in
Quando informar no campo email "deanwhinchester"
E clicar em create an account
Entao o sistema exibe mensagem de email invalido

@camposObrigatorios
Cenario: Testar campos obrigatorios 
Dado que eu esteja na tela de cadastro
Quando eu preencher o campo zip/postal
E eu clicar em registrar 
Entao o sistema exibe a mensagem dos campos obrigatorios

@pesquisarProduto
Cenario: Validar resultado de pesquisa
Dado que eu esteja logado
Quando eu pesquisar um produto 
Entao o sistema exibe a quantidade de resultados relacionado a pesquisa

@RemoverProduto
Cenario: Remover produto antes de finalizar a compra 
Dado que eu esteja na tela principal
Quando eu adicionar dois produtos ao carrinho
E eu remover um produto
Entao o sistema exibe o carrinho com apenas um produto

@termosDeServico
Cenario: Termos obrigatorios
Dado que eu esteja na tela do carrinho de compras
Quando eu fizer o checkout 
Entao o sistema exibe mensagem para concordar com os termos de servico


@RealizarCompra
Cenario: Realizar compra
Dado que eu loguei no sistema 
Quando eu adicionar um produto ao carrinho
E eu fiz o checkout 
E eu escolher a forma de pagamento 
E eu confirmar meu pedido 
Entao o sistema exibe a confirmacao do pedido
