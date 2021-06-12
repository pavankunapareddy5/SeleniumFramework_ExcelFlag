package com.testcrew.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.ExceptionUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Listener Class used to Generate Extent Report

public class ExtentListener implements ITestListener {

  public ExtentHtmlReporter htmlReporter;
  public ExtentReports extent;
  public ExtentTest logger;

  @Override
  public void onStart(ITestContext testContext) {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  // time stamp
    String repName = "Test - Report - " + timeStamp + ".html";
    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/" + repName); // specify location
    htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");

    extent = new ExtentReports();

    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Host name", "localhost");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("user", "Pavan");

    htmlReporter.config().setDocumentTitle("Amazon Test Project"); // Title of report
    htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.STANDARD);
  }

  @Override
  public void onTestStart(ITestResult result) {
    /*com.relevantcodes.extentreports.ExtentTest test = ExtentReport.report.startTest(result.getTestName());
    ExtentManager.setExtest(test);*/
  }

  @Override
  public void onTestSuccess(ITestResult tr) {
    logger = extent.createTest(tr.getName()); // create new entry in the report
    logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information
  }

  @Override
  public void onTestFailure(ITestResult tr) {
    logger = extent.createTest(tr.getName()); //create new entry in the report
    logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    logger.log(Status.FAIL, ExceptionUtil.getStackTrace(tr.getThrowable()));
    String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
    File f = new File(screenshotPath);
    if (f.exists()) {
      try {
        logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void onTestSkipped(ITestResult tr) {
    logger = extent.createTest(tr.getName());
    logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onFinish(ITestContext testContext) {
    extent.flush();
  }
}

