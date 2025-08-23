package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://duckduckgo.com");
    }
    @Test
    public void checkPageTitle() {
        // System.out.println("Test method executed")
        //  System.out.println("PageTitle----"+ driver.getTitle());
        // String pageName = driver.getTitle();
        //  assert pageName.equals("google") : "Page name is incorrect!";

        Assert.assertEquals(driver.getTitle(), "google", "Page name is mismatch!");
    }
    @Test
    public void checkPageLogo() {
        boolean isLogoDisplayed=false;
        //driver.findElement(By.tagName("logo")).isDisplayed();
        // Assert.assertTrue(isLogoDisplayed,"Yes is logo is Displayed.");
        Assert.assertFalse(isLogoDisplayed,"Yes is logo is Not Displayed!");

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}