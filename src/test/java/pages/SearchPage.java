package pages;

import maps.SearchMap;
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
    SearchMap searchMap;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        searchMap = new SearchMap();
        PageFactory.initElements(driver, searchMap);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By btnSacola = By.xpath("//*[@id='goToCheckoutButton']//button");

        WebElement botao = wait.until(ExpectedConditions.presenceOfElementLocated(btnSacola));

// Scroll
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", botao);

// Pequena espera (modal carregar)
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", botao);

    }
}
