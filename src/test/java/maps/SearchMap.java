package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchMap {
    @FindBy(xpath = "//span[contains(text(),'Escada Baw & Miaw Grafite para Cães e Gatos')]")
    public WebElement nomeProduto;

    @FindBy(xpath = "//*[@id='produto-href']//ptz-card-price-section//span[2]")
    public WebElement precoProduto;

    @FindBy(xpath = "//*[@id='produto-href']//button")
    public WebElement botaoAdicionar;

}
