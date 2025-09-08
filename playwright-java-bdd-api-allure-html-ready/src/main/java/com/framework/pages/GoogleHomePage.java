package com.framework.pages;
import com.microsoft.playwright.Locator; 
import com.microsoft.playwright.Page;
public class GoogleHomePage {
    private Page page;
    public GoogleHomePage(Page page){ this.page = page; }
    public void navigate(String baseUrl){
        page.navigate(baseUrl);
        Locator consent = page.locator("button:has-text('I agree'), button:has-text('Accept all'), button:has-text('Agree'), button:has-text('Accept')");
        if (consent.count() > 0) { consent.first().click();
        }
        if (page.locator("textarea[name='q']").count() > 0) {
        	page.waitForSelector("textarea[name='q']"); 
        } 
        else { 
        	page.waitForSelector("input[name='q']"); 
        	
        }
    }
    public void search(String query){
        if (page.locator("textarea[name='q']").count() > 0) {
            page.locator("textarea[name='q']").first().click();
            page.locator("textarea[name='q']").first().fill(query);
        } else {
            page.locator("input[name='q']").first().click();
            page.locator("input[name='q']").first().fill(query);
        }
        page.keyboard().press("Enter");
    }
}
