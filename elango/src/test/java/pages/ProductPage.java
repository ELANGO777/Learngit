package pages;

import Reports.Reporting;
import com.aventstack.extentreports.Status;

import Base.Baseclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage extends Baseclass {


    @FindBy(id="twotabsearchtextbox")
    private WebElement txtProductSearch;

    @FindBy(xpath = " //span[contains(text(),'Aple iPhone 12 (64GB) - Green')]")
    private WebElement productResult;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void productSearch(String productName){
        setText(txtProductSearch,productName+ Keys.ENTER);
        Reporting.extentTest.log(Status.INFO,"Entered product name as "+productName);

    }

    public boolean isProductDisplayed(){
        return isDisplayed(productResult);
    }



}
