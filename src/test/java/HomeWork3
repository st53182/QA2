import model.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork3 {
    private final String URL = "http://rus.delfi.lv";
    private final By ARTICLEMAINPAGE = By.tagName("article");
    private final By TITLEMAINPAGE = By.tagName("h1");
    private final By COMMENTCOUNT = By.xpath(".//a[contains(@class,\"text-red\")]");
    private final By ARTICLEMIDPAGE = By.xpath(".//div[contains(@class, \"article-title\")]");
    private final By ARTICLECOMMENTPAGE = By.xpath(".//div[@id='comments-listing']");
    private final By COMMENT_COUNT_COMMENT_PAGE_ANON = By.xpath(".//li[@class = 'as-link']//span[@class = 'type-cnt']");
    private final By COMMENT_COUNT_COMMENT_PAGE_REG = By.xpath(".//li[@class = 'as-link is-active']//span[@class = 'type-cnt']");


    @Test
    public void commentArticleCheck() {
        System.setProperty("webdriver.chrome.driver", "C://Users/754794/Desktop/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        List<WebElement> articlesMainPage = driver.findElements(ARTICLEMAINPAGE);
        Article articleMainPage = getArticle(articlesMainPage, 5);

        String mainPageTitleTxt = articleMainPage.getTitle();
        Integer mainPageCommentCountInt = articleMainPage.getCommentCount();

        System.out.println(mainPageTitleTxt);
        System.out.println(mainPageCommentCountInt);

        String mainPageTitleTxtMod = mainPageTitleTxt.substring(0,mainPageTitleTxt.length()-1);

        driver.findElement(By.linkText(mainPageTitleTxtMod)).click();

        List<WebElement> articlesMidPage = driver.findElements(ARTICLEMIDPAGE);
        Article articleMidPage = getArticle(articlesMidPage,0);

        String midPageTitleTxt = articleMidPage.getTitle();
        Integer midPageCommentCountInt = articleMidPage.getCommentCount();

        System.out.println(midPageTitleTxt);
        System.out.println(midPageCommentCountInt);

        Assertions.assertEquals(mainPageTitleTxt,midPageTitleTxt,"Title on main page and mid page are not equal");
        Assertions.assertEquals(mainPageCommentCountInt,midPageCommentCountInt,"Amount of comments on main page and mid page are not equal");


        driver.findElement(By.partialLinkText(midPageCommentCountInt.toString())).click();

        List<WebElement> articlesCommentPage = driver.findElements(ARTICLECOMMENTPAGE);

        Article articleCommentPage = getArticle(articlesCommentPage,0);

        String commentPageTitleTxt = articleCommentPage.getTitle();


        System.out.println(commentPageTitleTxt);

        // Find comment count on comment page (Annonimie)
        WebElement commentCountAnon = driver.findElement(COMMENT_COUNT_COMMENT_PAGE_ANON);

        // Find comment count on comment page (Registretie)
        WebElement commentCountReg = driver.findElement(COMMENT_COUNT_COMMENT_PAGE_REG);

        String commentCountAnonTxt = commentCountAnon.getText();
        String commentCountRegTxt = commentCountReg.getText();



        // Take out integer from string
        Integer commentCountAnonInt;
        Integer commentCountRegInt;

        if (commentCountAnonTxt.equals("")) {
            commentCountAnonInt = 0;
        }
        else
        {
            commentCountAnonInt = Integer.parseInt(commentCountAnonTxt.substring(1,commentCountAnonTxt.length()-1));
        }
        if (commentCountRegTxt.equals("")) {
            commentCountRegInt = 0;
        }
        else
        {
            commentCountRegInt = Integer.parseInt(commentCountRegTxt.substring(1,commentCountRegTxt.length()-1));
        }

        Assertions.assertEquals(midPageTitleTxt,commentPageTitleTxt,"Title on mid page and comment page are not equal");



        // Total count
        Integer totalCommentCount = commentCountAnonInt + commentCountRegInt;

        // Compare
        Assertions.assertEquals(mainPageCommentCountInt, totalCommentCount, "Amount of comments on main page and comment page are not equal");

















    }

    private Article getArticle(List<WebElement> elements, int i) {
        WebElement selectedArticleMainPage = elements.get(i);
        Article currentArticle = new Article();

        currentArticle.setTitle(selectedArticleMainPage.findElement(TITLEMAINPAGE).getText());

        List<WebElement> commentCountersMainPage = selectedArticleMainPage.findElements(COMMENTCOUNT);

        if(commentCountersMainPage.isEmpty())
        {
            currentArticle.setCommentCount(0);
        } else
        {
            currentArticle.setCommentCount(commentCountersMainPage.get(0).getText());

        }
        return currentArticle;

    }
}
