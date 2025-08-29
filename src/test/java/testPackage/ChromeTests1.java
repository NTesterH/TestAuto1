package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChromeTests1 {
    private WebDriver driver;
    /** Task1
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

    /** Task2
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

    /** Task3
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">webdriver</a>]
     * Close Google Chrome
     */
    @Test
    public void searchForSelenium() {
        driver.get("https://duckduckgo.com/");
        By searchBox =By.name("q");
        driver.findElement(searchBox).sendKeys("Selenium WebDriver");
        driver.findElement(searchBox).submit();
        By firstResultLinkLocator = By.xpath("//article[contains(@id,'r1-0')]//h2/a");
        String firstResultLink = driver.findElement(firstResultLinkLocator).getAttribute("href");
       // System.out.println(firstResultLink);
       // driver.get(firstResultLink);
        Assert.assertEquals(firstResultLink, "https://www.selenium.dev/documentation/webdriver/", "The first result link is not as expected.");

    }

    /** Task5
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Search for [Cucumber IO]
     * Assert that the link of the second result contains [<a href="https://www.linkedin.com">...</a>]
     * Close Google Chrome
     */

    @Test
    public void searchForCucumber()
    {
        driver.get("https://duckduckgo.com/");
        By searchBox = By.name("q");
        driver.findElement(searchBox).sendKeys("Cucumber IO");
        driver.findElement(searchBox).submit();
        By secondResultLinkLocator = By.xpath("//article[contains(@id,'r1-2')]//h2/a");
        String secondResultLink = driver.findElement(secondResultLinkLocator).getAttribute("href");
       // System.out.println(secondResultLink);
        Assert.assertNotNull(secondResultLink);
        Assert.assertTrue(secondResultLink.contains("linkedin.com"), "The second result link does not contain linkedin.com");
    }

    /** Task6
     *Open Google Chrome
     * Navigate to [<a href="http://the-internet.herokuapp.com/checkboxes">...</a>]
     * Check Checkbox 1
     * Assert that both Checkboxes are checked
     * Close Google Chrome
     */
    @Test
    public void checkCheckboxes()
    {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        By checkbox1Locator = By.xpath("//form[@id='checkboxes']/input[1]");
        By checkbox2Locator = By.xpath("//form[@id='checkboxes']/input[2]");
       // System.out.println("checkbox1 check status is "+driver.findElement(checkbox1Locator).isSelected());
       // System.out.println("checkbox2 check status is "+driver.findElement(checkbox2Locator).isSelected());
        driver.findElement(checkbox1Locator).click();
        Assert.assertTrue(driver.findElement(checkbox1Locator).isSelected(),"Checkbox 1 is not selected!");
        Assert.assertTrue(driver.findElement(checkbox2Locator).isSelected(),"Checkbox 2 is not selected!");
    }
    /** Task7
     * Open Google Chrome
     * Navigate to [<a href="https://www.w3schools.com/html/html_tables.asp">html_tables</a>]
     * Assert that the Country for the Company [Ernst Handel] is [Austria]
     * Close Google Chrome
     */
    @Test
    public void checkCountryForCompany()
    {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        By countryLocator = By.xpath("//table[@id='customers']//td[text()='Ernst Handel']/following-sibling::td[2]");
        String country = driver.findElement(countryLocator).getText();
       // System.out.println("The country for Ernst Handel is "+country);
        Assert.assertEquals(country,"Austria","The country for Ernst Handel is not Austria!");
    }

    /** Task8
     *Open Google Chrome
     * Navigate to [<a href="http://the-internet.herokuapp.com/upload">the-internet</a>]
     * Upload a small image file
     * Assert that the file was uploaded successfully
     * Close Google Chrome
     */
    @Test
    public void uploadSmallImage()
    {
        driver.get("http://the-internet.herokuapp.com/upload");
        By fileInputLocator = By.id("file-upload");
        By uploadButtonLocator = By.id("file-submit");
        By uploadedFilesLocator = By.id("uploaded-files");
        String filePath = System.getProperty("user.dir") + "/src/test/resources/test.png";
        // System.out.println("The file path is "+filePath);
        driver.findElement(fileInputLocator).sendKeys(filePath);
        driver.findElement(uploadButtonLocator).click();
        String uploadedFileName = driver.findElement(uploadedFilesLocator).getText();
       // System.out.println("The uploaded file name is "+uploadedFileName);
        Assert.assertEquals(uploadedFileName,"test.png","The uploaded file name is not as expected!");
    }

    /**  Task9
     * Open Google Chrome
     * Navigate to [<a href="https://jqueryui.com/resources/demos/droppable/default.html">drag demo</a>]
     * Drag [Drag me to my target] and drop it on [Drop here]
     * Assert that the text has been changed to [Dropped!]
     * Close Google Chrome
     */
    @Test
    public void dragAndDrop() {
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        By dragMeLocator = By.id("draggable");
        By dropHereLocator = By.id("droppable");
        System.out.println("The text before drop is "+driver.findElement(dropHereLocator).getText());

        new Actions(driver)
                .dragAndDrop(driver.findElement(dragMeLocator),driver.findElement( dropHereLocator))
                .perform();

         System.out.println("The text after drop is "+driver.findElement(dropHereLocator).getText());
         Assert.assertEquals(driver.findElement(dropHereLocator).getText(), "Dropped!", "The text after drop is not as expected!");

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

//    @BeforeClass
//    public void setUp()
//    {
//        driver= new ChromeDriver();
//    }
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }
}

