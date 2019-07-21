package core;

import config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverContainer {

    private static WebDriver driver;

    public WebDriverContainer() {
    }

    public static WebDriver getInstance(String driverType) {

        if (driver == null) {

            switch (driverType) {
                case "UbuntuChrome":
                    new DesiredCapabilities();
                    URL serverUrl = null;
                    try {
                        serverUrl = new URL(Constants.chromeDriverPath);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    driver = new RemoteWebDriver(serverUrl, capabilities);
                    driver.manage().window().maximize();
                    break;
                case "MacChrome":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "MacFirefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(15, SECONDS);
        }
        return driver;
    }
}