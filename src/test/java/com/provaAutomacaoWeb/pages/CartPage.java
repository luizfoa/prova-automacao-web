package com.provaAutomacaoWeb.pages;

import com.provaAutomacaoWeb.core.Driver;
import com.provaAutomacaoWeb.maps.CartMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    CartMap cartMap;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        cartMap = new CartMap();
        PageFactory.initElements(Driver.getDriver(), cartMap);
    }

    public String getPrecoCarrinho() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver ->
                driver.getCurrentUrl().contains("sacola") ||
                        driver.getCurrentUrl().contains("checkout")
        );

        WebElement elemento = wait.until(d ->
                cartMap.precoCarrinho
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String valor = "";

        for (int i = 0; i < 5; i++) {
            valor = (String) js.executeScript(
                    "return arguments[0].innerText;",
                    elemento
            );

            if (valor != null && !valor.trim().isEmpty()) {
                break;
            }

            Thread.sleep(1000);
        }

        return valor.trim();
    }
}
