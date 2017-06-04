package com.tests.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Hemo on 5/31/2017.
 */

// create user with invalid Email
public class createnewtest {
    static WebDriver driver;
    static Wait<WebDriver> wait;
    @Test
    // check if the email is already taken
    public void newusertest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.github.com/");
        WebElement user =driver.findElement(By.name("user[login]"));
        WebElement email =driver.findElement(By.name("user[email]"));
        WebElement password= driver.findElement(By.name("user[password]"));
        user.sendKeys("SwaniEryani");
        email.sendKeys("aleryanisilwan@gmail.com");
        password.sendKeys("Silwan123456");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/button")).click();
        WebElement el= driver.findElement(By.tagName("body"));

        boolean result;
        try {
            result = el.getText().contains("There were problems creating your account.");
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }

}
