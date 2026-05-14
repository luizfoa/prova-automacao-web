package com.provaAutomacaoWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class SearchPage {

    private WebDriver driver;


    private By primeiroProduto = By.xpath("//*[@id=\"produto-href\"]/ptz-card/div/div[1]/ptz-card-button/button");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void selecionarProduto() {

        driver.findElement(primeiroProduto).click();
    }
}
