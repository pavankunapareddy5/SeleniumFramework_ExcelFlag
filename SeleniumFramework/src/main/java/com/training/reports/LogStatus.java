package com.training.reports;

public class LogStatus {

    public static void pass(String message) {
        ExtentManager.getTest().log(com.relevantcodes.extentreports.LogStatus.PASS, message);
    }

}
