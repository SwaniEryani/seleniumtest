package com.tests.webdriver;

import org.junit.Assert;
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
public class searchTest {
    static WebDriver driver;
    static Wait<WebDriver> wait;
// search test
    @Test
    public  void searchtesting()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://github.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium!");
        element.submit();
        System.out.println("title:"+ driver.getTitle());
        Assert.assertTrue("title should start differently",
                driver.getTitle().contains("Selenium! · GitHub"));

        driver.quit();

    }
    /*@Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.github.com/");


        boolean result;
        try {
            result = firstPageContainsSelenium();
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
    private static boolean firstPageContainsSelenium() {

        WebElement el= driver.findElement(By.name("q"));
        el.sendKeys(" Selenium \n");


        el.submit();
       // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
                       public Boolean apply(WebDriver webDriver) {
                           System.out.println("Searching ...");
                           return webDriver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]")) != null;
                       }
                   }
        );
        return driver.findElement(By.tagName("body")).getText().contains("Selenium");
    }*/
}
