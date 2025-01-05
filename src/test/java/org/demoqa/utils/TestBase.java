package org.demoqa.utils;

import org.apache.log4j.Logger;
import org.demoqa.core.drivers_initializer.drivers.AppiumMobileDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;

public class TestBase {

    public static Logger log = Logger.getLogger(TestBase.class);

    public static AppiumMobileDriver appiumMobileDriver;
    public WebDriverWait wait;
    public Properties properties;
}
