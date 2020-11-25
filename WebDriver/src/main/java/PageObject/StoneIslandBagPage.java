package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StoneIslandBagPage  extends AbstractPage
{

    @FindBy(xpath = "//*[@id='main']/div[1]/section[1]/div/div[2]/div[2]/div[3]/div/div/button[2]/span[1]")
    private WebElement AddMoreProducts;

    @FindBy(xpath = "//div[@class='inner']/descendant-or-self::span[@class='value']")
    private WebElement counterOfProducts;
    public StoneIslandBagPage(WebDriver driver)
    {
        super(driver);
    }

    public StoneIslandBagPage addOneMoreProduct()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(AddMoreProducts))
                .click();
        return this;
    }

    public int numberOfSelectedProducts()
    {
        return Integer.parseInt(counterOfProducts.getText());
    }

}
