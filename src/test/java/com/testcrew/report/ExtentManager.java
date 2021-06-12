package com.testcrew.report;

import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {

  public static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

  public static ExtentTest getTest() {
    return extest.get();
  }

  public static void setExtest(ExtentTest test) {
    extest.set(test);
  }


}

