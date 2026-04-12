package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By cookies = By.id("onetrust-accept-btn-handler");
    private By campoBusca = By.id("headerSearch");
    private By botaoBusca = By.cssSelector("ptz-icon");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void aceitarCookies() {
        driver.findElement(cookies).click();
    }

    public void buscarProduto(String produto) {
        driver.findElement(campoBusca).sendKeys(produto);
        driver.findElement(botaoBusca).click();
    }
}

