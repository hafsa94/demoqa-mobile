package org.demoqa.core.interfaces;

public interface AppiumMobileDriverProvider<T> {
    /**
     * Gets mobile driver.
     *
     * @return the mobile driver
     */
    T getAppiumMobileDriver();
}
