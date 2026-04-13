package com.provaAutomacaoWeb.automacaoWeb;

import com.provaAutomacaoWeb.core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.provaAutomacaoWeb.pages.CartPage;
import com.provaAutomacaoWeb.pages.HomePage;
import com.provaAutomacaoWeb.pages.SearchPage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TesteWeb {

    WebDriver driver;
    Driver driverWeb;

    @Before
    public void setup() {
        driverWeb = new Driver("chrome");
        driver = Driver.getDriver();

        driver.get("https://www.petz.com.br");
    }

    @Test
    public void validarPrecoProduto() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        CartPage cartPage = new CartPage(driver);


        homePage.aceitarCookies();
        homePage.buscarProduto("Escada Baw & Miaw Grafite para Cães e Gatos");

        assertTrue(searchPage.getNomeProduto().contains("Escada Baw"));

        String valorEsperado = searchPage.getPrecoProduto();

        searchPage.adicionarAoCarrinho();
        searchPage.irParaSacola();

        String valorCarrinho = cartPage.getPrecoCarrinho();

        System.out.println("Produto: " + valorEsperado);
        System.out.println("Carrinho: " + valorCarrinho);

        assertEquals(valorEsperado, valorCarrinho);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



