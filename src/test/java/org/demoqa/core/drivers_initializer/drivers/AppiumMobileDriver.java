package org.demoqa.core.drivers_initializer.drivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.demoqa.utils.PropReader;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * The type Mobile driver.
 */
public abstract class AppiumMobileDriver<D extends AppiumDriver> {

    private final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();
    private final int timeout = Integer.parseInt(PropReader.readConfig("timeout"));

    /**
     * This method initialize capabilities values and return Capabilities object
     * <p>
     * Instantiates a new Mobile driver.
     */

    @NotNull
    static DesiredCapabilities init(String capabilitiesFile) {
        if (isNotValid(capabilitiesFile))
            Assert.fail("Please provide a capabilitiesFile for mobile.");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> capabilities = mapper.readValue(new File((capabilitiesFile)), Map.class);
            if (capabilities.isEmpty())
                Assert.fail("Please provide capabilities file for mobile");
            for (Map.Entry<String, Object> entry : capabilities.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (entry.getKey().equalsIgnoreCase("appium:app")) {
                    value = new File(value.toString()).getAbsoluteFile();
                    System.out.println(value);
                    if (value == null)
                        Assert.fail("Please provide the mobile app name or check if the app exists in your project resource folder");
                }
                desiredCapabilities.setCapability(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return desiredCapabilities;
    }

    private static boolean isNotFound(String capabilitiesFile) {
        File file = new File(capabilitiesFile);
        return !file.exists();
    }

    private static boolean isNotValid(String capabilitiesFile) {
        return isNull(capabilitiesFile) || capabilitiesFile.isEmpty() || isNotFound(capabilitiesFile);
    }

    private static boolean isNull(String capabilitiesFile) {
        return capabilitiesFile == null;
    }

    abstract D createDriver();

    public AppiumDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void setup() {
        driverThreadLocal.set(createDriver());
    }

    public void removeDriver() {
        driverThreadLocal.remove();
    }
}
