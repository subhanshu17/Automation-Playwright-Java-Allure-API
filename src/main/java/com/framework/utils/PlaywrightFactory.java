package com.framework.utils;
import com.microsoft.playwright.*;
public class PlaywrightFactory {
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    public static void init() {
        String headless = EnvConfig.get("headless"); String slowMoStr = EnvConfig.get("slowMo"); int slowMo = 0; try { slowMo = Integer.parseInt(slowMoStr); } catch (Exception ignored) {}
        tlPlaywright.set(Playwright.create());
        BrowserType.LaunchOptions opts = new BrowserType.LaunchOptions().setHeadless("true".equalsIgnoreCase(headless)).setSlowMo((double) slowMo);
        tlBrowser.set(tlPlaywright.get().chromium().launch(opts));
        tlContext.set(tlBrowser.get().newContext());
        tlPage.set(tlContext.get().newPage());
    }
    public static Page getPage() { return tlPage.get(); }
    public static Browser getBrowser() { return tlBrowser.get(); }
    public static void close() { if (tlContext.get()!=null) tlContext.get().close(); if (tlBrowser.get()!=null) tlBrowser.get().close(); if (tlPlaywright.get()!=null) tlPlaywright.get().close(); tlPage.remove(); tlContext.remove(); tlBrowser.remove(); tlPlaywright.remove(); }
}
