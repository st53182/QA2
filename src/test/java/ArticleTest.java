import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticleTest {
private final String URL = "http://delfi.lv";
private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
private final By COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']//a");
private WebDriver driver;

@Test
public void articleTitleCheck() {
    //Add path to Driver
    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

    //Open browser
    driver = new ChromeDriver();

    //Set it to the Full Screen
    driver.manage().window().maximize();

    //Open home page
    driver.get(URL);

    //Find the first article title
    //WebElement homePageTitle = driver.findElement(TITLE);

    //Save to String
    String homePageTitle = driver.findElement(TITLE).getText();

    //Click on article
    driver.findElement(TITLE).click();

    //Find Title
    WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);

    //Save to String
    String articlePageTitleTxt = articlePageTitle.getText();

    //Check article title
    Assertions.assertEquals(homePageTitle, articlePageTitleTxt,"Wrong article page title!");

    //Find comment count
    WebElement commentCount = driver.findElement(COMMENT_COUNT);

    //Click on comment count
    driver.findElement(COMMENT_COUNT).click();

    //Find title

    //Save to string
    String commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();
    //Check title
    Assertions.assertEquals(homePageTitle, commentPageTitle,"Wrong Comment Page Title");
    //Close browser


}
@AfterEach
public void closeBrowser()
{
    driver.close();
}
}
