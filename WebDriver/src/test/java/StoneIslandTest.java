import PageObject.StoneIslandHomePage;
import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StoneIslandTest {

    private WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webserver.chrome.driver", "D://Trash/chromedriver_win32/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AddingALargeNumberOfProducts() {
        int expectedAddingALargeNumberOfProductsNumber = new StoneIslandHomePage(driver)
                .openPage()
                .goToPageWithProducts()
                .goToProductPage()
                .selectProductSize()
                .goToBag()
                .addOneMoreProduct()
                .numberOfSelectedProducts();
        Assert.assertTrue(expectedAddingALargeNumberOfProductsNumber > 1, "Test of adding a large items to cart failed!!");
    }


    @AfterMethod(alwaysRun = true)
    public void browserExit(){
        driver.quit();
        driver=null;
    }
}

