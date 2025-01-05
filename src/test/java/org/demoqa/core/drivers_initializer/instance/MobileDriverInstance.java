package org.demoqa.core.drivers_initializer.instance;

import org.demoqa.core.drivers_initializer.drivers.AppiumMobileDriver;
import org.demoqa.core.drivers_initializer.enums.AppiumMobilePlatforms;
import org.demoqa.utils.PropReader;

import java.util.HashMap;
import java.util.Map;

import static org.demoqa.core.drivers_initializer.drivers.DriverConstants.*;

public class MobileDriverInstance {

    private static final Map<String, AppiumMobilePlatforms> mobilePlatformsMap = new HashMap<>();

    static {
        mobilePlatformsMap.put(ANDROID, AppiumMobilePlatforms.ANDROID_DRIVER);
        mobilePlatformsMap.put(IOS, AppiumMobilePlatforms.IOS_DRIVER);
    }

    /**
     * EnumMap implementation of the Strategy design pattern. to get the MobileDriver instance.
     *
     * @return the mobile driver
     */

    public static AppiumMobileDriver getAppiumMobileDriver() {
        String driverType = System.getProperty("appium-mobile-driver", PropReader.readConfig(APPIUM_MOBILE_DRIVER));
        return mobilePlatformsMap.get(driverType).getAppiumMobileDriver();
    }
}