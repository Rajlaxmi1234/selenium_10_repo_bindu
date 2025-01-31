package extentReport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToAddScreenshotToReport {
@Test
public void addScreenshot()
{
	String timeStamp = LocalDateTime.now().toString().replace(":", "-");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://demowebshop.tricentis.com/");
	 
	TakesScreenshot ts=(TakesScreenshot)driver;
	String screenShot = ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentSparkReporter spark=new ExtentSparkReporter("./html_reports/"+timeStamp+"raj.html");
	ExtentReports extReports=new ExtentReports();
	extReports.attachReporter(spark);
	ExtentTest test=extReports.createTest("addScreenshot");
	test.log(Status.PASS, "Screenshot adding into report");
	test.addScreenCaptureFromBase64String(screenShot);
	extReports.flush();
	
}
}
