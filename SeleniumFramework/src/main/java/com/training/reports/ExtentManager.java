
package com.training.reports;

import com.relevantcodes.extentreports.ExtentTest;

import java.lang.reflect.Method;

public class ExtentManager {

    public static  ThreadLocal<ExtentTest>  extest = new ThreadLocal<ExtentTest>();

        public static ExtentTest getTest() {

            return extest.get();
        }

        public static void setExtest(ExtentTest test){

            extest.set(test);
        }


}

