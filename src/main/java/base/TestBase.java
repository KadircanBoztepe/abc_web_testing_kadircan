package base;

import com.thoughtworks.gauge.*;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ExtentReportUtil;
import utils.ReuseStoreData;

import java.net.MalformedURLException;




public class TestBase {
    private final Logger log = LogManager.getLogger(TestBase.class);


    public void setUp() {
        DriverManager.getInstances().createLocalDriver();
        log.info("{} launched",DriverManager.getInstances().getBrowsersType());
    }

    @AfterStep
    public void afterStep(ExecutionContext context) {
        var take_screens = Boolean.parseBoolean(System.getenv("screenshot_after_each_step"));
        if (take_screens)
            Gauge.captureScreenshot();
        String stepName = context.getCurrentStep().getText();
        ExtentReportUtil.log(stepName+" Step Is Worked");
        if (context.getCurrentScenario().getIsFailing()) {
            String errorMessage = context.getCurrentStep().getErrorMessage();
            ExtentReportUtil.fail(stepName + " Step Failed: " + errorMessage);
            DriverManager.getInstances().quitDriver();
        }
    }

    @AfterScenario
    public void afterScenario(ExecutionContext executionContext) {
        String scenarioName = executionContext.getCurrentScenario().getName();
        ExtentReportUtil.log(scenarioName+ " Scenario Finished");
        DriverManager.getInstances().quitDriver();
        ReuseStoreData.remove();
        if (executionContext.getCurrentScenario().getIsFailing()) {
            log.info("TEST BAŞARISIZ");
        } else {
            log.info("TEST BAŞARILI");
        }

        log.info("_________________________________________________________________________" + "\r\n");
    }

    @BeforeSpec
    public void setFileNameForGauge(ExecutionContext context) {
        var fileName = context.getCurrentSpecification().getFileName();
        setFileName(fileName);
    }
    private void setFileName(String fileName) {
        int firstIndex = fileName.lastIndexOf('/');
        int lastIndex = fileName.lastIndexOf('.');
        GetFileName.getInstance().setFileName(fileName.substring(firstIndex + 1, lastIndex));
    }

    @BeforeSuite
    public void beforeSuite(ExecutionContext context) {
        ExtentReportUtil.initReport();

    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext) throws MalformedURLException {
        String scenarioName = executionContext.getCurrentScenario().getName();
        ExtentReportUtil.startTest(scenarioName, "Gauge Scenario Started");
        log.info("_________________________________________________________________________" + "\r\n");
        log.info("------------------------SCENARIO-------------------------");
        log.info("SCENARIO NAME: " + executionContext.getCurrentScenario().getName());
        log.info("SCENARIO TAG: " + executionContext.getCurrentScenario().getTags().toString());
    }

    @AfterSpec
    public void afterSpec(ExecutionContext executionContext) {
        log.info("Spec running finished");
        log.info("=========================================================================" + "\r\n");
       DriverManager.getInstances().quitDriver();
    }
}
