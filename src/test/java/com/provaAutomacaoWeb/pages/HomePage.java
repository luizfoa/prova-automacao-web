package com.provaAutomacaoWeb.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage {

    private WebDriver driver;
    private By btnCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void acessarSite() {

        driver.get("https://www.petz.com.br/");
        driver.findElement(btnCookies).click();
    }

    public void buscarProduto(String produto) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By searchBox = By.xpath("//input[contains(@placeholder,'O que seu pet precisa')]");

        for (int i = 0; i < 3; i++) {

            try {

                WebElement campoBusca = wait.until(
                        ExpectedConditions.elementToBeClickable(searchBox)
                );

                campoBusca.click();

                campoBusca.clear();

                campoBusca.sendKeys(produto);

                campoBusca.sendKeys(Keys.ENTER);

                break;

            } catch (StaleElementReferenceException e) {

                System.out.println("Elemento ficou stale. Tentando novamente...");
            }
        }
    }

}

