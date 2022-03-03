package Test;


import DataProviders.CustomData;

import Reports.Reporting;
import core.Driver;
import pages.ProductPage;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonProductSearch {

    private WebDriver driver;

    @Parameters({"browser","url"})
    @BeforeMethod
    public void setUp(String browser,String url){
        driver = Driver.openBrowser(browser);
        driver.navigate().to(url);
    }

    @Test(dataProvider="productsearch",dataProviderClass = CustomData.class)
    public void amazonproductSearch(String productName){

        Reporting.createTest("Validate Product Appears");
        ProductPage productPage=new ProductPage(driver);
        Reporting.extentTest.log(Status.INFO,"Application Launched");
        productPage.productSearch(productName);

        Assert.assertTrue(productPage.isProductDisplayed(),"Product Not Displayed");

        Reporting.extentTest.log(Status.PASS,"Product Displayed",Driver.getScreen(driver));

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess())
            Reporting.extentTest.log(Status.FAIL,result.getThrowable().getMessage(),Driver.getScreen(driver));
        Driver.closeBrowser(driver);
    }
}
