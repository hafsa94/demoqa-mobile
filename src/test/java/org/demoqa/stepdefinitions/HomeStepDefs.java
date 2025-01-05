package org.demoqa.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.demoqa.pages.HomePage;
import org.demoqa.utils.TestBase;
import org.testng.Assert;

import static org.demoqa.pages.BasePage.waitFor;

public class HomeStepDefs extends TestBase {

    private HomePage homePage;
    public HomeStepDefs() {
        homePage = new HomePage(appiumMobileDriver);
    }

    @When("user is at the home page")
    public void userIsAtTheHomePage() {
        Assert.assertTrue(homePage.isHomePage());
    }

    @And("user scrolls {string} to the page")
    public void userScrollToThePage(String direction) {
        homePage.scrollTo(direction, 15);
    }

    @Then("user clicks the My Lists icon")
    public void userClicksTheMyListsIcon() {
        Assert.assertTrue(homePage.clickMyListsButton());
        waitFor(3);
    }

    @And("user clicks the History icon")
    public void userClicksTheHistoryIcon() {
        Assert.assertTrue(homePage.clickHistoryButton());
        waitFor(3);
    }

    @And("user clicks the NearBy icon")
    public void userClicksTheNearByIcon() {
        Assert.assertTrue(homePage.clickNearByButton());
        waitFor(3);
    }

    @And("user clicks the Explore icon")
    public void userClicksTheExploreIcon() {
        Assert.assertTrue(homePage.clickExploreButton());
        waitFor(3);
    }

    @When("user clicks the Search icon")
    public void userClicksTheSearchIcon() {
        Assert.assertTrue(homePage.clickSearchBar());
    }

    @And("user searches {string} in the search bar")
    public void userSearchesInTheSearchBar(String search) {
        Assert.assertTrue(homePage.enterSearchBar(search));
    }

    @Then("verify search bar expanded with returned results")
    public void verifySearchBarExpandedWithReturnedResults() {
        Assert.assertTrue(homePage.isSearchResultListVisible());
    }

    @And("close search button to clear and return to home page")
    public void closeSearchButtonToClearAndReturnToHomePage() {
        Assert.assertTrue(homePage.closeSearch());
        Assert.assertTrue(homePage.isHomePage());
    }

    @And("user navigates to the Settings page")
    public void userNavigatesToTheSettingsPage() {
        Assert.assertTrue(homePage.goToSettings());
    }

    @Then("verify user is able to disable all options")
    public void verifyUserIsAbleToDisableAllOptions() {
        Assert.assertTrue(homePage.disableAllSettingsOptions());
    }

    @And("verify user is able to return to home page")
    public void verifyUserIsAbleToReturnToHomePage() {
        Assert.assertTrue(homePage.back());
        Assert.assertTrue(homePage.isHomePage());
    }
}

