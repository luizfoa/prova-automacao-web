package com.provaAutomacaoWeb.hooks;

import com.provaAutomacaoWeb.core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        Driver.driver = new ChromeDriver();
        Driver.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}