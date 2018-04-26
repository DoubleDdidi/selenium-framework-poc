package com.deodato.step_definitions;

import com.deodato.helpers.Log;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Hooks {
    public static WebDriver driver;


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws Exception {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "src/executableDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @BeforeTest
    public void startScenario(Scenario scenario) throws Exception {
        System.out.println("Starting the scenario: " + scenario.getName());

    }

    @AfterSuite
    public void closeScenario(Scenario scenario) throws Exception {
        System.out.println("The scenario: " + scenario.getName() + " finished with status " + scenario.getStatus());

    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();

    }

}