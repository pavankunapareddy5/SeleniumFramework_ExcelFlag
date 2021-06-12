package com.testcrew.base;

import com.testcrew.constants.Constants;
import com.testcrew.report.ExtentReport;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
  private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

  @BeforeSuite
  public void setUpSuite() {
    ExtentReport.initializeReports();
  }

  @BeforeSuite
  public void tearDownSuite() {
    ExtentReport.closeReports();
  }

  @AfterMethod
  public void afterTest(ITestResult result){
    FileInputStream fileInputStream;
    try {
      fileInputStream = new FileInputStream(Constants.TESTDATAPATH);
      Workbook workbook = new XSSFWorkbook(fileInputStream);
      Sheet sheet = workbook.getSheet(Constants.RUNMANAGERSHEETNAME);
      Map<String, Integer> headersMap = new LinkedHashMap<>();
      for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
        headersMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), i);
      }
      for (int columnIndex = 1; columnIndex < sheet.getPhysicalNumberOfRows(); columnIndex++) {
        String testCaseName = sheet.getRow(columnIndex).getCell(headersMap.get("TestCaseName")).getStringCellValue();
        String executeFlag = sheet.getRow(columnIndex).getCell(headersMap.get("Execute")).getStringCellValue();
        if (executeFlag.equalsIgnoreCase("yes") && result.getMethod().getMethodName().equals(testCaseName)){
          String status = result.getStatus() == ITestResult.FAILURE ? "Failed" : "Passed";
          sheet.getRow(columnIndex).getCell(headersMap.get("Status")).setCellValue(status);
        }
      }
      fileInputStream.close();
      FileOutputStream fileOutputStream = new FileOutputStream(Constants.TESTDATAPATH);
      workbook.write(fileOutputStream);
      fileOutputStream.close();
    } catch (Exception e) {
      LOGGER.error(e);
    }
    LOGGER.debug("Successfully wrote back test result to TestRunner sheet");
  }
}
