package com.testcrew.listener;

import com.relevantcodes.extentreports.ExtentTest;
import com.testcrew.report.ExtentManager;
import com.testcrew.report.ExtentReport;
import java.lang.reflect.Method;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ISuiteListener, ITestListener {


  public void onStart(ISuite iSuite) {

  }

  public void onFinish(ISuite iSuite) {

  }

  public void onTestStart(ITestResult iTestResult, Method m) {
    ExtentTest test = ExtentReport.report.startTest(m.getName());
    // ExtentReport.report.endTest(test);
    ExtentManager.setExtest(test);
  }

  public void onTestStart(ITestResult iTestResult) {

  }

  public void onTestSuccess(ITestResult iTestResult) {
    ExtentReport.report.endTest(ExtentManager.getTest());
    ExtentReport.report = null;
  }

  public void onTestFailure(ITestResult iTestResult) {
    ExtentReport.report.endTest(ExtentManager.getTest());
  }

  public void onTestSkipped(ITestResult iTestResult) {
    ExtentReport.report.endTest(ExtentManager.getTest());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    ExtentReport.report.endTest(ExtentManager.getTest());
  }

  public void onStart(ITestContext iTestContext) {

  }

  public void onFinish(ITestContext iTestContext) {

  }
}
