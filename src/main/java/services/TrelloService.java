package services;

import com.codeborne.selenide.WebDriverRunner;
import helpers.CSVReader;
import org.openqa.selenium.WebDriver;
import pageObject.BoardPage;
import pageObject.BoardsPage;
import pageObject.LoginPage;

import java.io.IOException;

import static config.Constants.testDataFileLocator;

/**
 * @author Pavel_Chaika
 * Service methods for Trello system
 */
public class TrelloService {

    private WebDriver driver;

    public TrelloService(WebDriver driver) {
        this.driver = driver;
        WebDriverRunner.setWebDriver(driver);
    }

    public void login() {

        CSVReader reader = new CSVReader();
        LoginPage loginPage = new LoginPage(driver);

        try {
            loginPage.fillEmailField(reader.read(testDataFileLocator, 0)[0]);
            loginPage.fillPasswordField(reader.read(testDataFileLocator, 1)[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginPage.clickLogInButton();
    }

    public void createNewBoard() {

        CSVReader reader = new CSVReader();
        BoardPage boardPage = new BoardPage(driver);
        BoardsPage boardsPage = new BoardsPage(driver);

        boardsPage.clickCreateNewBoardButton();
        try {
            boardsPage.fillAddBoardTitleField(reader.read(testDataFileLocator, 2)[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boardsPage.clickCreateBoardButton();
        boardPage.verifyTestBoardTitle();
    }
}