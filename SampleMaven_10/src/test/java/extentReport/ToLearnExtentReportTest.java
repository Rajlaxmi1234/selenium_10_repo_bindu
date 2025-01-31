package extentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReportTest {
@Test
public void extentReport() {
	String timeStamp = LocalDateTime.now().toString().replace(":", "-");
	//step 1: create an instance of ExtentSparkReporter
	ExtentSparkReporter spark=new ExtentSparkReporter("./html_reports/"+timeStamp+"raj.html");
	
	//step 2: create an instance of ExtentReports
	ExtentReports extReports=new ExtentReports();
	
	//step 3: Attach ExtentSparkReporter to ExtentReports
	extReports.attachReporter(spark);
	
	//step 4: create an instance of Extent Test
	ExtentTest test=extReports.createTest("createReport");
	
	//step 5:call log() to provide status and the message
	test.log(Status.PASS, "message added into report");
	test.log(Status.INFO, "adding into status");
	
	//step 6:call flush()
	extReports.flush();
}
}
