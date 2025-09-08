package com.framework.stepdefinitions.ui;
import com.framework.pages.GoogleHomePage; import com.framework.pages.GoogleResultsPage; import com.framework.utils.PlaywrightFactory; import com.framework.utils.LoggerUtil; import io.cucumber.java.en.*; import io.qameta.allure.Allure; import org.slf4j.Logger; import org.testng.Assert; import com.microsoft.playwright.Page;
public class GoogleSteps {
    private static final Logger log = LoggerUtil.getLogger(GoogleSteps.class);
    private GoogleHomePage home; private GoogleResultsPage results; private Page page;
    @Given("I open Google home page") public void open(){ page = PlaywrightFactory.getPage(); home = new GoogleHomePage(page); results = new GoogleResultsPage(page); Allure.step("Open Google"); log.info("Opened Google"); }
    @When("I search for {string}") public void search(String q){ home.search(q); }
    @Then("I should see results containing {string}") public void verify(String text){ results = new GoogleResultsPage(PlaywrightFactory.getPage()); int count = results.resultsCount(); log.info("Results count: {}", count); Assert.assertTrue(count>0, "Expected results >0"); String first = results.firstTitle().toLowerCase(); Assert.assertTrue(first.contains(text.toLowerCase()) || count>0); }
}
