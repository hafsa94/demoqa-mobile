package org.demoqa.stepdefinitions;

import io.appium.java_client.Setting;
import io.cucumber.java.*;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.demoqa.utils.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.demoqa.core.drivers_initializer.instance.MobileDriverInstance.getAppiumMobileDriver;

public class Hooks extends TestBase {

    public static Logger log = Logger.getLogger(Hooks.class);

    public WebDriverWait wait;
    public Properties properties;

    @BeforeAll
    public static void initializeDriver() {
        try {
            appiumMobileDriver = getAppiumMobileDriver();
            appiumMobileDriver.setup();
            appiumMobileDriver.getDriver().setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
            log.info("Successfully initialized the driver");
        } catch (Exception e) {
            log.info("Failed to initialize the driver " + e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (!scenario.isFailed()) {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
            String timestamp = sdf.format(now);
            String fileName = String.format("%1s%2s%3s-%4s.png",
                    System.getProperty("user.dir"),
                    "/src/test/resources/screenshots/",
                    scenario.getName().replaceAll(" ", "-"),
                    timestamp);
            log.info("Screenshot File Name: " + fileName);
            File scrFile = ((TakesScreenshot) appiumMobileDriver.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterAll
    public static void resetDriver() {
        try {
            appiumMobileDriver.getDriver().quit();
            appiumMobileDriver.removeDriver();
            log.info("Successfully quit the driver");
        } catch (Exception e) {
            log.info("Failed to quit the driver " + e);
        }
    }
}
