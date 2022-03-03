package core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class Driver {
    public static WebDriver openBrowser(String browser){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            default:
                driver=new ChromeDriver();
        }

        return driver;

    }

    public static void closeBrowser(WebDriver driver){
        driver.quit();;
    }

    public static String takeScreenshot(WebDriver driver)  {
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String fileName = "Screenshot_"+dateFormat.format(new Date())+".png";
        String path = System.getProperty("user.dir")+"\\reports\\"+fileName;
        try{

            FileUtils.copyFile(ss.getAbsoluteFile(),new File(path));
        }
        catch (IOException e){
            System.out.println("Cannot Copy file:"+e.getMessage());
        }

        return fileName;
    }

    public static Media getScreen(WebDriver driver){

       return MediaEntityBuilder.
               createScreenCaptureFromPath(takeScreenshot(driver))
               .build();

    }

}
