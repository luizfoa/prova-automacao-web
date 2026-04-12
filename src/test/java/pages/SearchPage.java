package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;

    private By nomeProduto = By.xpath("//span[contains(text(),'Escada Baw & Miaw Grafite para Cães e Gatos')]");
    private By precoProduto = By.xpath("//*[@id='produto-href']//ptz-card-price-section//span[2]");
    private By botaoAdicionar = By.xpath("//*[@id='produto-href']//button");
    private By botaoIrSacola = By.xpath("//*[@id='goToCheckoutButton']//button");




    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNomeProduto() {
        return driver.findElement(nomeProduto).getText();
    }

    public String getPrecoProduto() {
        return driver.findElement(precoProduto).getText().trim();
    }

    public void adicionarAoCarrinho() {
        driver.findElement(botaoAdicionar).click();
    }

    public void irParaSacola() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By btnSacola = By.xpath("//*[@id='goToCheckoutButton']//button");

        WebElement botao = wait.until(ExpectedConditions.presenceOfElementLocated(btnSacola));

// Scroll
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", botao);

// Pequena espera (modal carregar)
        Thread.sleep(1000);

// Click via JS (mais confiável)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", botao);
        //driver.findElement(botaoIrSacola).click();

    }
}
