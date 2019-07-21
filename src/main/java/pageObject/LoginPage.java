package pageObject;

import config.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Pavel_Chaika1
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By loginButton = By.cssSelector("#login");
    private final By emailField = By.cssSelector("#user");
    private final By passwordField = By.cssSelector("#password");

    public void openLoginPage() {

        open(Constants.loginPageURL);
        $(loginButton).shouldHave(exactValue("Log In"));

    }

    public void fillEmailField(String email) {

        $(emailField).val(email);
    }

    public void fillPasswordField(String password) {

        $(passwordField).val(password);
    }

    public void clickLogInButton() {

        $(loginButton).click();
    }
}