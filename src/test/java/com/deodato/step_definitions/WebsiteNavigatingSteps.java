package com.deodato.step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import com.deodato.helpers.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.openqa.selenium.support.PageFactory;
import com.deodato.pageobjects.WebsiteHomePage;


public class WebsiteNavigatingSteps {
    public WebDriver driver;
    public String basicUrl = null;
    public String firstNewsStoryTitle = null;
    public String firstNewsStoryReferencePage = null;

    private static Logger Log = Logger.getLogger(Log.class.getName());

    public WebsiteNavigatingSteps() {
        driver = Hooks.driver;
    }

    @Given("^I navigate to the '(.+?)' website$")
    public void i_navigate_to_the_website(String website) throws Throwable {
        basicUrl = "http://www." + website + ".com";
        driver.get(basicUrl);
    }

    @When("^I go to the (.+?) section$")
    public void i_go_to_the_section(String sportType) throws Throwable {
        driver.navigate().to(basicUrl + "/sport/" + sportType);

    }


    @And("^I select the first news story$")
    public void i_select_the_first_news_story() throws Throwable {
        // Select the first news story and obtains its page reference code
        PageFactory.initElements(driver, WebsiteHomePage.class);
        firstNewsStoryTitle = WebsiteHomePage.first_news_history.getText();
        firstNewsStoryReferencePage = WebsiteHomePage.first_news_history.getAttribute("href");
        WebsiteHomePage.first_news_history.click();
        System.out.println("First story news selected is: " + firstNewsStoryTitle);
    }

    @Then("^I should see the first story page$")
    public void i_should_see_the_first_story_page() throws Exception {
        assertEquals(firstNewsStoryReferencePage, driver.getCurrentUrl());
    }


}