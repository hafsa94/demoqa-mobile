package org.demoqa.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.demoqa.core.drivers_initializer.drivers.AppiumMobileDriver;
import org.demoqa.utils.PropReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static Logger log = Logger.getLogger(BasePage.class);

    private final int timeout = Integer.parseInt(PropReader.readConfig("timeout"));
    AppiumMobileDriver appiumMobileDriver;
    WebDriverWait wait;

    public BasePage(AppiumMobileDriver appiumMobileDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumMobileDriver.getDriver()), this);
        this.appiumMobileDriver = appiumMobileDriver;
        wait = new WebDriverWait(this.appiumMobileDriver.getDriver(),  Duration.ofSeconds(timeout));
    }

    /**
     * This method simulates typing into an element, which may set its value.
     *
     * @param element   used to find the element
     * @param inputText string to send to the element
     * @return true when successfully send input to the element otherwise false
     */
    public boolean enterFieldInput(WebElement element, String inputText) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(inputText);
            return true;
        } catch (Exception e) {
            log.error("Failed to send input to the element", e);
        }
        return false;
    }

    /**
     * This method clicks on the given element
     *
     * @param element used to find the element
     * @return true when successfully click the element otherwise false
     */
    public boolean clickWhenReady(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            return true;
        } catch (Exception e) {
            log.info("Failed to click on element" + e);
        }
        return false;
    }

    /**
     * This method returns the visible (i.e. not hidden by CSS) text of this element, including sub-elements
     *
     * @param element used to find the element
     * @return the visible text of this element otherwise empty string
     */
    public String getTextOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (Exception e) {
            log.error("Failed to get the text of the element", e);
        }
        return "";
    }

    /**
     * This method checks if the element is visible
     *
     * @param element used to find the element
     * @return true if the element is visible otherwise false
     */
    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            log.info("The element on waitVisibility method not found " + e);
        }
        return false;
    }


    public static void waitFor(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000L);
        } catch (InterruptedException e) {
            log.info(e);
        }
    }
    public void touchActionScrolling(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence actions = new Sequence(finger, 1);
        actions.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, startY));
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        actions.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumMobileDriver.getDriver().perform(List.of(actions));
    }

    public void scrollTo(String direction, int times) {
        if (direction.equals("down")) {
            Dimension dimensions = appiumMobileDriver.getDriver().manage().window().getSize();
            int width = dimensions.getWidth() / 2;

            for (int i = 0; i < times; i++) {
                int startY = (int) (dimensions.getHeight() * 0.7);
                int endY = (int) (dimensions.getHeight() * 0.25);
                touchActionScrolling(width, startY, width, endY);
            }
        }
        if (direction.equals("up")) {
            Dimension dim = appiumMobileDriver.getDriver().manage().window().getSize();
            int width = dim.getWidth() / 2;

            for (int i = 0; i < times; i++) {
                int startY = (int) (dim.getHeight() * 0.25);
                int endY = (int) (dim.getHeight() * 0.7);
                touchActionScrolling(width, startY, width, endY);
            }
        }
        if (direction.equals("left")) {
            Dimension dim = appiumMobileDriver.getDriver().manage().window().getSize();
            int height = dim.getWidth() / 2;

            for (int i = 0; i < times; i++) {
                int startX = dim.getWidth() / 2;
                int endX = dim.getWidth() / 3;
                touchActionScrolling(startX, height, endX, height);
            }
        }
        if (direction.equals("right")) {
            Dimension dim = appiumMobileDriver.getDriver().manage().window().getSize();
            int height = dim.getWidth() / 2;

            for (int i = 0; i < times; i++) {
                int startX = dim.getWidth() / 3;
                int endX = dim.getWidth() / 2;
                touchActionScrolling(startX, height, endX, height);
            }
        }
    }

}




