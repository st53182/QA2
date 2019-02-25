import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork2 {
    private WebDriver driver;
    private final String URL = "http://delfi.lv";
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By BRUNCH_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT_ARTICLE_TITLE = By.xpath(".//h1[@class = 'article-title']//a");
    private final By COMMENT_COUNT_MAIN_PAGE = By.xpath(".//a[contains(@class,'comment-count')]");
    private final By COMMENT_COUNT_BRUNCH_PAGE = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENT_COUNT_COMMENT_PAGE_ANON = By.xpath(".//li[@class = 'as-link']//span[@class = 'type-cnt']");
    private final By COMMENT_COUNT_COMMENT_PAGE_REG = By.xpath(".//li[@class = 'as-link is-active']//span[@class = 'type-cnt']");


    @Test
    public void articleTitleCommentCheck() {

        // Add chrome driver
        System.setProperty("webdriver.chrome.driver", "C://Users/754794/Desktop/chromedriver_win32/chromedriver.exe");
        // Open browser
        driver = new ChromeDriver();
        // Switch it to the Full screen
        driver.manage().window().fullscreen();
        // Navigate to delfi.lv page
        driver.get(URL);
        // Find first article Title
        WebElement homePageTitle = driver.findElement(TITLE);
        // Save it to String
        String homePageTitleTxt = homePageTitle.getText();
        // Find comment count on main page
        WebElement commentCountMainPage = driver.findElement(COMMENT_COUNT_MAIN_PAGE);
        // Save it to String
        String commentCountMainPageTxt = commentCountMainPage.getText();
        // Take out integer from string
        commentCountMainPageTxt = commentCountMainPageTxt.replace("(", "");
        commentCountMainPageTxt = commentCountMainPageTxt.replace(")", "");
        Integer commentCountMainPageInt;
        if (commentCountMainPageTxt.equals("")) {
            commentCountMainPageInt = 0;
        } else {
            commentCountMainPageInt = Integer.parseInt(commentCountMainPageTxt);
        }


        // Click on Article
        driver.findElement(TITLE).click();
        // Find Article Title
        WebElement brunchPageTitle = driver.findElement(BRUNCH_TITLE);

        // Save it to String
        String brunchPageTitleTxt = brunchPageTitle.getText();

        // Find comment count on brunch page
        WebElement commentCountBrunchPage = driver.findElement(COMMENT_COUNT_BRUNCH_PAGE);

        // Save it to String
        String commentCountBrunchPageTxt = commentCountBrunchPage.getText();

        // Take out integer from string
        commentCountBrunchPageTxt = commentCountBrunchPageTxt.replace("(", "");
        commentCountBrunchPageTxt = commentCountBrunchPageTxt.replace(")", "");
        Integer commentCountBrunchPageInt;
        if (commentCountBrunchPageTxt.equals("")) {
            commentCountBrunchPageInt = 0;
        } else {
            commentCountBrunchPageInt = Integer.parseInt(commentCountBrunchPageTxt);
        }


        // Compare / Check article comments
        Assertions.assertEquals(commentCountMainPageInt, commentCountBrunchPageInt, "Not equal");

        // Compare / Check article title
        Assertions.assertEquals(homePageTitleTxt, brunchPageTitleTxt, "Not the Same, Punch Web programmer in the face");

        //Click on comment link
        driver.findElement(COMMENT_COUNT_BRUNCH_PAGE).click();

        // Find Article Title
        WebElement commentPageTitle = driver.findElement(COMMENT_ARTICLE_TITLE);

        //Save to String
        String commentPageTitleTxt = commentPageTitle.getText();

        // Check / Compare
        //Assertions.assertEquals(brunchPageTitleTxt, commentPageTitleTxt, "Is not equal");

        // Find comment count on comment page (Annonimie)
        WebElement commentCountAnon = driver.findElement(COMMENT_COUNT_COMMENT_PAGE_ANON);
        // Find comment count on comment page (Registretie)
        WebElement commentCountReg = driver.findElement(COMMENT_COUNT_COMMENT_PAGE_REG);


        // Save it to String
        String commentCountAnonTxt = commentCountAnon.getText();
        String commentCountRegTxt = commentCountReg.getText();

        // Take out integer from string
        commentCountAnonTxt = commentCountAnonTxt.replace("(", "");
        commentCountAnonTxt = commentCountAnonTxt.replace(")", "");
        commentCountRegTxt = commentCountRegTxt.replace("(", "");
        commentCountRegTxt = commentCountRegTxt.replace(")", "");
        Integer commentCountAnonInt;
        Integer commentCountRegInt;
        if (commentCountAnonTxt.equals("")) {
            commentCountAnonInt = 0;
        } else {
            commentCountAnonInt = Integer.parseInt(commentCountAnonTxt);
        }
        if (commentCountRegTxt.equals("")) {
            commentCountRegInt = 0;
        } else {
            commentCountRegInt = Integer.parseInt(commentCountRegTxt);
        }

        // Total count
        Integer totalCommentCount = commentCountAnonInt + commentCountRegInt;
        // Compare
        Assertions.assertEquals(commentCountBrunchPageInt, totalCommentCount, "not equal");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }


}
