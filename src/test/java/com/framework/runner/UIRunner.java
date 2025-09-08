package com.framework.runner; import io.cucumber.testng.AbstractTestNGCucumberTests; import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources/features/ui", glue = {"com.framework.stepdefinitions.ui","com.framework.hooks"}, tags = "@ui", plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/ui-cucumber-report.html","json:target/ui-cucumber.json"}, monochrome = true)
public class UIRunner extends AbstractTestNGCucumberTests { }
