package org.demoqa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.demoqa.core.drivers_initializer.drivers.AppiumMobileDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(accessibility = "Explore")
    private WebElement exploreNavBtn;

    @AndroidFindBy(accessibility = "My lists")
    private WebElement myListsNavBtn;

    @AndroidFindBy(accessibility = "History")
    private WebElement historyNavBtn;

    @AndroidFindBy(accessibility = "Nearby")
    private WebElement nearByNavBtn;

    @AndroidFindBy(accessibility = "Search Wikipedia")
    private WebElement searchBarBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement searchInput;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_results_list")
    private WebElement searchResultList;

    @AndroidFindBy(accessibility = "Clear query")
    private WebElement closeSearch;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/menu_overflow_button")
    private WebElement menuBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/explore_overflow_settings")
    private WebElement settingsBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/switchWidget")
    private List<WebElement> settingsOptions;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement navigateBackBtn;

    public HomePage(AppiumMobileDriver driver) {
        super(driver);
    }

    public boolean clickExploreButton() {
        return clickWhenReady(exploreNavBtn);
    }

    public boolean clickMyListsButton() {
        return clickWhenReady(myListsNavBtn);
    }

    public boolean clickHistoryButton() {
        return clickWhenReady(historyNavBtn);
    }

    public boolean clickNearByButton() {
        return clickWhenReady(nearByNavBtn);
    }

    public boolean clickSearchBar() {
        return clickWhenReady(searchBarBtn);
    }

    public boolean enterSearchBar(String searchText) {
        return enterFieldInput(searchInput, searchText);
    }

    public boolean isSearchResultListVisible() {
        return isElementVisible(searchResultList);
    }

    public boolean closeSearch() {
        return clickWhenReady(closeSearch) && clickWhenReady(closeSearch);
    }

    public boolean goToSettings() {
        return clickWhenReady(menuBtn) && clickWhenReady(settingsBtn);
    }

    public boolean disableAllSettingsOptions() {
        waitFor(2);
        for (WebElement option: settingsOptions) {
            if (!clickWhenReady(option)) {
                return false;
            }
        }
        return true;
    }

    public boolean back() {
        return clickWhenReady(navigateBackBtn);
    }

    public boolean isHomePage() {
        return isElementVisible(exploreNavBtn);
    }
}
