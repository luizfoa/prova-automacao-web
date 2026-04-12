package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeMap {
    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookies;

    @FindBy(id = "headerSearch")
    public WebElement campoBusca;

    @FindBy(css = "ptz-icon")
    public WebElement botaoBusca;
}
