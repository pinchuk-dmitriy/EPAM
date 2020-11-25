package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoneIslandProductPage extends AbstractPage
{

    @FindBy(xpath = "//*[@id='sizeSelection-4_16001796gq']")
    private WebElement productSize;

    @FindBy(xpath = "//*[@class='text' and text()='Добавить в Мои Покупки']")
    private WebElement toCartButton;

    public StoneIslandProductPage(WebDriver driver)
    {
        super(driver);
    }

    public StoneIslandProductPage selectProductSize()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(productSize))
                .click();
        return this;
    }

    public StoneIslandBagPage goToBag()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(toCartButton))
                .click();
        return new StoneIslandBagPage(driver);
    }

}
