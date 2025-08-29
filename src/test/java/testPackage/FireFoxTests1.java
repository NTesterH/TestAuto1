package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FireFoxTests1 {
    private WebDriver driver;
    /**
     * Open Mozilla Firefox
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    @Test
    public void checkFourthResultText() {
        driver.get("https://duckduckgo.com/");
        By searchBox = By.name("q");
        driver.findElement(searchBox).sendKeys("TestNG");
    }

    @BeforeMethod
    public void setUp()
    {
        // System.setProperty("webdriver.gecko.driver","path/to/geckodriver");
         driver = new FirefoxDriver();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
