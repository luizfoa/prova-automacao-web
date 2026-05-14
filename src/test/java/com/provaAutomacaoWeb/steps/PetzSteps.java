package com.provaAutomacaoWeb.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.provaAutomacaoWeb.core.DriverFactory;
import com.provaAutomacaoWeb.pages.CartPage;
import com.provaAutomacaoWeb.pages.HomePage;
import com.provaAutomacaoWeb.pages.SearchPage;


public class PetzSteps {

    private WebDriver driver;
    private HomePage home;
    private SearchPage results;
    private CartPage product;

    private String precoProduto;

    @Dado("que acesso o site da Petz")
    public void acessarSite() {
        driver = DriverFactory.getDriver();
        home = new HomePage(driver);
        home.acessarSite();
    }

    @Quando("busco pelo produto {string}")
    public void buscarProduto(String produto) {
        home.buscarProduto(produto);
    }

    @E("seleciono o produto")
    public void selecionarProduto() {
        results = new SearchPage(driver);
        results.selecionarProduto();
        product = new CartPage(driver);
    }

    @E("capturo o valor do produto")
    public void capturarValor() {
        precoProduto = product.capturarPrecoProduto();
    }

    @E("adiciono o produto à sacola")
    public void adicionarSacola() {
        product.adicionarNaSacola();
    }

    @Entao("valido que o valor na sacola é igual ao valor do produto")
    public void validarValor() {
        String precoSacola = product.capturarPrecoSacola();
        Assert.assertEquals(precoProduto, precoSacola);

        DriverFactory.quit();
    }
}


