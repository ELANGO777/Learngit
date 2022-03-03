package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Reporting {

    private static ExtentSparkReporter extentSparkReporter;
    private static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeTest
    public void initialiseReport(){
        String reportfile = System.getProperty("user.dir")+"\\reports\\automatedreport.html";
        extentSparkReporter = new ExtentSparkReporter(reportfile);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Environment","QA");
    }
    public static void createTest(String testcaseName){
        extentTest= extentReports.createTest(testcaseName);
    }
    @AfterTest
    public void closeReport(){
        extentReports.flush();
    }

}
