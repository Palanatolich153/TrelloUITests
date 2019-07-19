package helpers.log;

import core.WebDriverContainer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerTest extends WebDriverContainer implements ITestListener {

    String filePath = "src/main/resources/Screenshots";

    @Override
    public void onFinish(ITestContext Result) {

    }

    @Override
    public void onStart(ITestContext Result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    /**
     * When Test case get failed, this method is called.
     */
    @Override
    public void onTestFailure(ITestResult Result) {

        WebDriver driver = null;
        try {
            driver = WebDriverContainer.getInstance("Chrome");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(filePath + Result.getName() + ".png"));
            System.out.println("***Placed screen shot in " + filePath + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The name of the testcase failed is :" + Result.getName());
    }

    /**
     * When Test case get Skipped, this method is called.
     */
    @Override
    public void onTestSkipped(ITestResult Result) {

        System.out.println("The name of the testcase Skipped is :" + Result.getName());
    }

    /**
     * When Test case get Started, this method is called.
     */
    @Override
    public void onTestStart(ITestResult Result) {

        System.out.println(Result.getName() + " test case started");
    }

    /**
     * When Test case get passed, this method is called.
     */
    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("The name of the testcase passed is :" + Result.getName());
    }
}