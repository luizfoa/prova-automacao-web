package com.provaAutomacaoWeb.steps;

import com.provaAutomacaoWeb.core.Driver;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.provaAutomacaoWeb.pages.CartPage;
import com.provaAutomacaoWeb.pages.HomePage;
import com.provaAutomacaoWeb.pages.SearchPage;


import static org.junit.Assert.assertEquals;

public class PetzSteps {
    WebDriver driver = Driver.driver;

    HomePage homePage;
    SearchPage searchPage;
    CartPage cartPage;

    String valorProduto;
    String valorCarrinho;

    @Dado("que acesso o site Petz")
    public void acessoOSite() {
        Driver.getDriver().get("https://www.petz.com.br");
        homePage = new HomePage(driver);
        homePage.aceitarCookies();
    }

    @E("busco pelo produto {string}")
    public void buscoPeloProduto(String produto) {
        homePage = new HomePage(driver);
        homePage.buscarProduto(produto);
    }

    @E("seleciono o produto desejado")
    public void selecionoOProdutoDesejado() {
        searchPage = new SearchPage(driver);
        searchPage.adicionarAoCarrinho();

    }

    @E("capturo o valor do produto")
    public void capturoOValorDoProduto() {
        searchPage = new SearchPage(driver);
        valorProduto = searchPage.getPrecoProduto();
    }

    @Quando("adiciono o produto à sacola")
    public void adicionarOPrudutoASacola() throws InterruptedException {
        searchPage = new SearchPage(Driver.driver);
        searchPage.irParaSacola();
    }

    @Entao("o valor na sacola deve ser igual ao valor do produto")
    public void oValorNaSacolaDeveSerIgualAoValorDoProduto() throws InterruptedException {
        cartPage = new CartPage(Driver.driver);
        searchPage = new SearchPage(Driver.driver);

        valorCarrinho = cartPage.getPrecoCarrinho();

        assertEquals(valorProduto, valorCarrinho);
    }
}

