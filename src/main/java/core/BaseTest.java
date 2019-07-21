package core;

import helpers.log.ListenerTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pageObject.BoardsPage;
import pageObject.LoginPage;
import services.TrelloService;

@Listeners(ListenerTest.class)

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {

        driver = WebDriverContainer.getInstance("MacChrome");

        LoginPage loginPage = new LoginPage(driver);
        BoardsPage boardsPage = new BoardsPage(driver);
        TrelloService service = new TrelloService(driver);

        loginPage.openLoginPage();
        service.login();
        boardsPage.verifyHomePageButton();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}