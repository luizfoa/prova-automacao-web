package com.provaAutomacaoWeb.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static WebDriver driver;

    public Driver(String navegador){

        switch (navegador.toLowerCase()){

            case "chrome":

                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);

                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new IllegalArgumentException("Navegador inválido: " + navegador);
        }

        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);

            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }
}