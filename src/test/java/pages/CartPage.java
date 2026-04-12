package pages;

import maps.CartMap;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    CartMap cartMap;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        cartMap = new CartMap();
        PageFactory.initElements(driver, cartMap);
    }

    public String getPrecoCarrinho() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // espera página
        wait.until(d ->
                d.getCurrentUrl().contains("sacola") ||
                        d.getCurrentUrl().contains("checkout")
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
