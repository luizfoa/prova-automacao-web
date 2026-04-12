package pages;

import maps.HomeMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    HomeMap homeMap;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        homeMap = new HomeMap();
        PageFactory.initElements(driver, homeMap);
    }

    public void aceitarCookies() {
        homeMap.cookies.click();
    }

    public void buscarProduto(String produto) {
        homeMap.campoBusca.sendKeys(produto);
        homeMap.botaoBusca.click();
    }
}

