package pageObject;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Pavel Chaika
 * Page Object class for a New Board page
 */
public class BoardPage {

    private WebDriver driver;

    public BoardPage(WebDriver driver) {
        this.driver = driver;
        WebDriverRunner.setWebDriver(driver);
    }

    private final By testBoardTitle = By.xpath("//span[contains(text(),'TestBoard')]");

    public void verifyTestBoardTitle() {

        try {
            $(testBoardTitle).exists();
        } catch (InvalidSelectorException e) {
            Assert.fail("testBoardTitle has not been found");
        }
    }
}