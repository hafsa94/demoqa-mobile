package org.demoqa.core.drivers_initializer.drivers;

import io.appium.java_client.ios.IOSDriver;
import org.demoqa.utils.PropReader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.demoqa.core.drivers_initializer.drivers.DriverConstants.*;

public class BaseIOSDriver extends AppiumMobileDriver<IOSDriver> {

    @Override
    public IOSDriver createDriver() {
        try {
            if (System.getProperty("remote", PropReader.readConfig(REMOTE)).equalsIgnoreCase("true")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("appium:deviceName", System.getProperty("deviceName"));
                capabilities.setCapability("appium:platformVersion", System.getProperty("platformVersion"));
                capabilities.setCapability("appium:automationName", "XCUITest");
                capabilities.setCapability("appium:udid", System.getProperty("udid"));
                capabilities.setCapability("appium:app", System.getProperty("app"));
                capabilities.setCapability("appium:autoAcceptAlerts", true);
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:fullReset", false);
                return new IOSDriver(new URL(PropReader.readConfig(APPIUM_URL)), capabilities);
            } else {
                return new IOSDriver(new URL(PropReader.readConfig(APPIUM_URL)), init(PropReader.readConfig(IOS_CAPABILITIES)));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
