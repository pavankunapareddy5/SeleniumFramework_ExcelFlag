package com.testcrew.report;


import com.relevantcodes.extentreports.ExtentReports;
import com.testcrew.constants.Constants;
import java.io.File;

public class ExtentReport {

  public static ExtentReports report;

  private ExtentReport() {
    report = new ExtentReports(Constants.EXTENTREPORTPATH);
    report.loadConfig(new File(Constants.EXTENTCONFIGFILEPATH));
  }

  public static void initializeReports() {
    if (report == null) {
      new ExtentReport();
    }
  }

  public static void closeReports() {
    report.flush();
    report.close();
  }

}
