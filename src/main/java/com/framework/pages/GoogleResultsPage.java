package com.framework.pages;
import com.microsoft.playwright.Page;
public class GoogleResultsPage {
    private Page page; public GoogleResultsPage(Page page){ this.page = page; }
    public int resultsCount(){ return page.locator("div#search a h3").count(); }
    public String firstTitle(){ return resultsCount()==0? "" : page.locator("div#search a h3").first().innerText(); }
}
