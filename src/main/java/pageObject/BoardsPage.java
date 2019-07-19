package pageObject;

import com.codeborne.selenide.WebDriverRunner;
import config.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Pavel Chaika
 * Page Object class for Boards page
 */
public class BoardsPage {

    private WebDriver driver;

    public BoardsPage(WebDriver driver) {
        this.driver = driver;
        WebDriverRunner.setWebDriver(driver);
    }

    private final By homePageButton = By.xpath("//span[@name='house']");
    private final By createNewBoardButton = By.xpath("//span[contains(text(),'Create new board')]");
    private final By addBoardTitleField = By.xpath("//input[@placeholder='Add board title']");
    private final By createBoardButton = By.xpath("//span[contains(text(),'Create Board')]");

    public void verifyHomePageButton() {

        try {
            $(homePageButton).exists();
        } catch (InvalidSelectorException e) {
            Assert.fail("HomeButton has not been found");
        }
    }

    public void openBoardPage() {

        open(Constants.boardsPageURL);
        verifyHomePageButton();
    }

    public void clickCreateNewBoardButton() {

        try {
            $(createNewBoardButton).click();
        } catch (InvalidSelectorException e) {
            Assert.fail("CreateNewBoardButton has not been found");
        }
    }

    public void clickCreateBoardButton() {

        try {
            $(createBoardButton).click();
        } catch (InvalidSelectorException e) {
            Assert.fail("CreateBoardButton has not been found");
        }
    }

    public void fillAddBoardTitleField(String text) {

        try {
            $(addBoardTitleField).val(text);
        } catch (InvalidSelectorException e) {
            Assert.fail("AddBoardTitleField has not been found");
        }
    }
}