package com.provaAutomacaoWeb.pages;

import com.provaAutomacaoWeb.core.Driver;
import com.provaAutomacaoWeb.maps.SearchMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    SearchMap searchMap;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        searchMap = new SearchMap();
        PageFactory.initElements(Driver.getDriver(), searchMap);
    }

    public String getNomeProduto() {
        return searchMap.nomeProduto.getText();
    }

    public String getPrecoProduto() {
        return searchMap.precoProduto.getText().trim();
    }

    public void adicionarAoCarrinho() {
        searchMap.botaoAdicionar.click();
    }

    public void irParaSacola() throws InterruptedException {
        By botaoSacola = By.cssSelector("[data-testid='ptz-button-ir-para-sacola']");

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(botaoSacola));

        wait.until(ExpectedConditions.visibilityOf(btn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);

        Thread.sleep(500);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

    }
}
