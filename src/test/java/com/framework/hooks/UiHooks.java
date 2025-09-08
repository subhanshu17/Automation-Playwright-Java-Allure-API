package com.framework.hooks;
import com.framework.utils.EnvConfig; import com.framework.utils.PlaywrightFactory; import com.framework.utils.LoggerUtil; import io.cucumber.java.After; import io.cucumber.java.Before; import io.cucumber.java.Scenario; import io.qameta.allure.Allure; import com.microsoft.playwright.Page; import org.slf4j.Logger; import java.io.ByteArrayInputStream;
public class UiHooks {
    private static final Logger log = LoggerUtil.getLogger(UiHooks.class);
    @Before("@ui") public void before(){ EnvConfig.load(); PlaywrightFactory.init(); String base = EnvConfig.get("baseUrl"); PlaywrightFactory.getPage().navigate(base); log.info("Navigated to {}", base); }
    @After("@ui") public void after(Scenario scenario){ Page page = PlaywrightFactory.getPage(); if (scenario.isFailed() && page != null){ byte[] png = page.screenshot(new Page.ScreenshotOptions().setFullPage(true)); Allure.addAttachment("Screenshot - " + scenario.getName(), new ByteArrayInputStream(png)); log.error("Scenario failed: {}", scenario.getName()); } PlaywrightFactory.close(); }
}
