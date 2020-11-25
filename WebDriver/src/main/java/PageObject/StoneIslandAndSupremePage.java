package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoneIslandAndSupremePage extends AbstractPage
{

    @FindBy(xpath = "//*[@id='slot_53696']/descendant-or-self::a[@class='itemLink']")
    private WebElement productToAdding;

    public StoneIslandAndSupremePage(WebDriver driver)
    {
        super(driver);
    }

    public StoneIslandProductPage goToProductPage()
    {
       new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(productToAdding))
                .click();
        return new StoneIslandProductPage(driver);
    }
}
