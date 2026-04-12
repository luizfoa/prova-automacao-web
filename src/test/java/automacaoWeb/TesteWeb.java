package automacaoWeb;

import core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TesteWeb {

    WebDriver driver;
    Driver driverWeb;

    @Before
    public void setup() {
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.petz.com.br");
    }

    @Test
    public void validarPrecoProduto() throws InterruptedException {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        CartPage cart = new CartPage(driver);

        home.aceitarCookies();
        home.buscarProduto("Escada Baw & Miaw Grafite para Cães e Gatos");

        assertTrue(search.getNomeProduto().contains("Escada Baw"));

        String valorEsperado = search.getPrecoProduto();

        search.adicionarAoCarrinho();
        search.irParaSacola();

        String valorCarrinho = cart.getPrecoCarrinho();

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



