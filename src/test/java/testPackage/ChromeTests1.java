package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeTests1 {
    private WebDriver driver;
    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void checkPageTitle()
    {
        driver.get("https://duckduckgo.com/");
        Assert.assertEquals(driver.getTitle(),"Google","The title not the same.");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     */
    @Test
    public void checkLogoIsDisplayed()
    {
        driver.get("https://duckduckgo.com/");
        By logoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        Assert.assertTrue(driver.findElement(logoLocator).isDisplayed(), "DuckDuckGo logo is not  displayed!");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">webdriver</a>]
     * Close Google Chrome
     */
    @Test
    public void checkFirstResultLink() {
        driver.get("https://duckduckgo.com/");
        By searchBox =By.name("q");
        driver.findElement(searchBox).sendKeys("Selenium WebDriver");
        driver.findElement(searchBox).submit();
        By firstResultLinkLocator = By.xpath("//article[contains(@id,'r1-0')]//h2/a");
        String firstResultLink = driver.findElement(firstResultLinkLocator).getAttribute("href");
        System.out.println(firstResultLink);
       // driver.get(firstResultLink);
        Assert.assertEquals(firstResultLink, "https://www.selenium.dev/documentation/webdriver/", "The first result link is not as expected.");

    }
    @BeforeMethod
    private void setUp()
    {
        driver= new ChromeDriver();
    }

    @AfterMethod
    private void tearDown()
    {
        driver.quit();
    }


}

