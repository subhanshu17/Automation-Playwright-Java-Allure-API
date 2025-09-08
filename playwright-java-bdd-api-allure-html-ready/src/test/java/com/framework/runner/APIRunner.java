package com.framework.runner; import io.cucumber.testng.AbstractTestNGCucumberTests; import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources/features/api", glue = {"com.framework.stepdefinitions.api"}, tags = "@api", plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/api-cucumber-report.html","json:target/api-cucumber.json"}, monochrome = true)
public class APIRunner extends AbstractTestNGCucumberTests { }
