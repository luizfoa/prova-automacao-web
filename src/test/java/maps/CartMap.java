package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartMap {
    @FindBy(xpath = "//span[contains(text(),'R$')]")
    public WebElement precoCarrinho;
}
