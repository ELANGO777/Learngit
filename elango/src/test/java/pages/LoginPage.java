package pages;


import Base.Baseclass;
import Reports.Reporting;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Baseclass {


    @FindBy(id="txtUsername")
    private WebElement txtUsername;

    @FindBy(id="txtPassword")
    private WebElement txtPassword;

    @FindBy(id="btnLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//img[contains(@src,'logo.png')]")
    private WebElement imgLogo;

    public LoginPage(WebDriver driver){
        super(driver);
        int pnc;
        int pnc;
        PageFactory.initElements(driver,this);
    }


    public void login(String username,String password){
        setText(txtUsername,username);
        setText(txtPassword,password);
        submit(btnLogin);
        Reporting.extentTest.log(Status.INFO,"Entered Username as "+username+", password as "+password);

    }



}
