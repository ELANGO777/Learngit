package Test;


import DataProviders.CustomData;


import Reports.Reporting;
import core.Driver;
import pages.HomePage;
import pages.LoginPage;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import org.checkerframework.common.util.report.qual.ReportWrite;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    private WebDriver driver;

    @Parameters({"browser","url"})
    @BeforeMethod
    public void setUp(String browser,String url){
        driver = Driver.openBrowser(browser);
        driver.navigate().to(url);
       // Reporting.extentTest.log(Status.INFO,"Navigated to URL"+url);
       // Driver.takeScreenshot(driver);
    }

    @Test(dataProvider="login",dataProviderClass = CustomData.class)
    public void validateLogin(String username,String password){
        Reporting.createTest("Validate Login");
        LoginPage loginPage=new LoginPage(driver);
        Reporting.extentTest.log(Status.INFO,"Application Launched");
        loginPage.login(username,password);
        HomePage homePage=new HomePage(driver);

        Assert.assertEquals(true,homePage.isUserLoggedIn(),"Could not login ," +
                " Username->"+username+"password->"+password);

        Reporting.extentTest.log(Status.PASS,"Successfully Logged In",Driver.getScreen(driver));



    }

    @AfterMethod
    public void tearDown(ITestResult result){
       if(!result.isSuccess())
           Reporting.extentTest.log(Status.FAIL,result.getThrowable().getMessage(),Driver.getScreen(driver));
        Driver.closeBrowser(driver);
    }

}
