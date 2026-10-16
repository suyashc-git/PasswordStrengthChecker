
package com.example.passwordchecker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerSeleniumTest {

    @Test
    void testPasswordStrengthChecker() {
        
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless=new");
	WebDriver driver = new ChromeDriver(options);


        try {
            driver.get("http://localhost:8083");

            WebElement passwordField =
                    driver.findElement(By.id("password"));

            passwordField.sendKeys("Abcd123!");

            driver.findElement(By.id("checkButton")).click();

            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(10));

            wait.until(d ->
                    d.getCurrentUrl().contains("/check"));

            String pageText = driver.findElement(By.tagName("body"))
                    .getText();

            assertTrue(
                    pageText.toLowerCase().contains("strong"),
                    "The page should show a Strong password result."
            );

        } finally {
            driver.quit();
        }
    }
}
