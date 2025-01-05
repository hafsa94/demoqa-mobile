package org.demoqa.core.drivers_initializer.enums;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.demoqa.core.drivers_initializer.drivers.AppiumMobileDriver;
import org.demoqa.core.drivers_initializer.drivers.BaseAndroidDriver;
import org.demoqa.core.drivers_initializer.drivers.BaseIOSDriver;
import org.demoqa.core.interfaces.AppiumMobileDriverProvider;

public enum AppiumMobilePlatforms implements AppiumMobileDriverProvider<AppiumMobileDriver> {
    IOS_DRIVER() {
        @Override
        public AppiumMobileDriver<IOSDriver> getAppiumMobileDriver() {
            return new BaseIOSDriver();
        }
    },
    ANDROID_DRIVER() {
        @Override
        public AppiumMobileDriver<AndroidDriver> getAppiumMobileDriver() {
            return new BaseAndroidDriver();
        }
    }
}
