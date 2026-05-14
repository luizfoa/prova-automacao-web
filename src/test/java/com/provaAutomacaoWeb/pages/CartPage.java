package com.provaAutomacaoWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class CartPage {

    private WebDriver driver;

    private By precoProduto = By.xpath("//*/div[3]/div[2]/div/div/span");
    private By botaoAdicionar = By.xpath("//*[@id=\"goToCheckoutButton\"]/button");
    private By precoSacola = By.xpath("//*[@id=\"resumeValues\"]/div[2]/div[2]/div[2]/div");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String capturarPrecoProduto() {

        return driver.findElement(precoProduto).getText();
    }

    public void adicionarNaSacola() {
        driver.findElement(botaoAdicionar).click();
    }

    public String capturarPrecoSacola() {
        return driver.findElement(precoSacola).getText();
    }
}
