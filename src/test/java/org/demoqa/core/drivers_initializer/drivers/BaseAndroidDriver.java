package org.demoqa.core.drivers_initializer.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.demoqa.utils.PropReader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.demoqa.core.drivers_initializer.drivers.DriverConstants.*;

public class BaseAndroidDriver extends AppiumMobileDriver<AndroidDriver> {

    @Override
    public AndroidDriver createDriver() {
        try {
            if (System.getProperty("remote", PropReader.readConfig(REMOTE)).equalsIgnoreCase("true")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:deviceName", System.getProperty("deviceName"));
                capabilities.setCapability("appium:platformVersion", System.getProperty("platformVersion"));
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:app", System.getProperty("app"));
                capabilities.setCapability("appium:autoGrantPermissions", true);
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:fullReset", false);
                return new AndroidDriver(new URL(PropReader.readConfig(APPIUM_URL)), capabilities);
            } else {
                return new AndroidDriver(new URL(PropReader.readConfig(APPIUM_URL)), init(PropReader.readConfig(ANDROID_CAPABILITIES)));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
