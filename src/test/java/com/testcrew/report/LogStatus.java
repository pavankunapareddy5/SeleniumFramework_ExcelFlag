package com.testcrew.report;

import static com.relevantcodes.extentreports.LogStatus.PASS;

public class LogStatus {

  public static void pass(String message) {
    ExtentManager.getTest().log(PASS, message);
  }

}
