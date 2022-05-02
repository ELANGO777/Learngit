package pages;


import Base.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Baseclass {

    @FindBy(partialLinkText="Welcome")
    private WebElement txtWelcomeMessage;


 

    public boolean isUserLoggedIn(){
        return isDisplayed(txtWelcomeMessage);
    }

}
