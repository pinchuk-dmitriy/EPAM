package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoneIslandHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.stoneisland.com/ru";

    @FindBy(xpath = "//*[@id='slot_54446']/descendant-or-self::div[@class='ctabutton']")
    private WebElement ToComeInButton;
    
    public StoneIslandHomePage(WebDriver driver)
    {
        super(driver);
    }

    public StoneIslandHomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }

    public StoneIslandAndSupremePage goToPageWithProducts()
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(ToComeInButton))
                .click();
        return new StoneIslandAndSupremePage(driver);
    }
}
