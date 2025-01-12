package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    public static void initReport() {
        sparkReporter = new ExtentSparkReporter("extentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "Test");
    }

    public static void startTest(String testName, String description) {
        test = extent.createTest(testName, description);
    }

    public static void log(String message) {
        test.info(message);
    }

    public static void flushReport() {
        extent.flush();
    }
    public static void fail(String message) {
        if (extent != null) {
            test.fail(message);
        }
    }
    public static void pass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }
}