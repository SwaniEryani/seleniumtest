package com.tests.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Hemo on 5/31/2017.
 */
public class titleTest {
    // get title
    @Test
    public  void startWebDriver_1()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://github.com");
        Assert.assertTrue("title should start differently",
                driver.getTitle().startsWith("The world's leading software development platform · GitHub"));
        driver.close();
    }
}
