package com.deodato.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebsiteHomePage extends BaseClass {

    public WebsiteHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "(//*[@id='top-stories']//a[@class='faux-block-link__overlay'])[1]")
    public static WebElement first_news_history;

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	