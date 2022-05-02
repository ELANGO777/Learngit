package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	    public Baseclass(WebDriver driver) throws InterruptedException {
	        this.driver = driver;
	        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		  
	        int elango;
	    }

	    protected WebElement getElement(WebElement element){
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }


	    protected void setText(WebElement element,String text){
	        getElement(element).sendKeys(text);
	    }


	    protected void click(WebElement element){
	        getElement(element).click();
	    }

	    protected void submit(WebElement element){
	        getElement(element).submit();
	    }

	    protected boolean isDisplayed(WebElement element){
	        try{
	            return getElement(element).isDisplayed();
	        }
	        catch (Exception e){
	            System.out.println(e.getMessage());
	            return false;
	        }
	    }

	    protected void clickElement(WebElement element){

	       int counter = 3;

	       while (counter>=1){
	           try{
	               wait.until(ExpectedConditions.elementToBeClickable(element));
	               element.click();
	               break;
	           }
	           catch (Exception e){
	                counter--;
	           }
	       }


	    }



}
