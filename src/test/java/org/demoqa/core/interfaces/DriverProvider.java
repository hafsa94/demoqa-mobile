package org.demoqa.core.interfaces;


public interface DriverProvider<T> {

    /**
     * Gets browser.
     *
     * @return the browser
     */
    T getBrowser();
}
