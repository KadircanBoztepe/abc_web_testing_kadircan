package imp;


import base.TestBase;
import com.thoughtworks.gauge.Step;
import configuration.Configuration;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LaunchBrowserImp {

    Logger log = LogManager.getLogger(LaunchBrowserImp.class);

    @Step("Open <browser> and get <url>")
    public void lunchApp(String browser, String url) {
        System.setProperty("browser", browser);
        var base = new TestBase();
        base.setUp();
        DriverManager.getInstances().getDriver().get(url);
        log.info("{} browser launched and {} is opened", browser, url);
    }

    @Step("Open <browser> and get base url")
    public void lunchApp(String browser) {
        System.setProperty("browser", browser);
        var base = new TestBase();
        var baseUrl = Configuration.getInstance().getStringValueOfProp("base.url");
        base.setUp();
        DriverManager.getInstances().getDriver().get(baseUrl);
        log.info("{} browser launched and {} is opened", browser, baseUrl);
    }

    @Step("Open browser and get base url")
    public void lunchApp() {
        String defaultBrowser = Configuration.getInstance().getStringValueOfProp("default.browser");
        System.setProperty("browser", defaultBrowser);
        var base = new TestBase();
        var baseUrl = Configuration.getInstance().getStringValueOfProp("base.url");
        base.setUp();
        DriverManager.getInstances().getDriver().get(baseUrl);
        log.info("{} browser launched and {} is opened", defaultBrowser, baseUrl);
    }
}