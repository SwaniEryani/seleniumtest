package com.tests.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;


/**
 * Created by Hemo on 5/27/2017.
 */
public class logintest {
    static WebDriver driver;
    static Wait<WebDriver> wait;
 // login test
    @Test
    public  void logIn()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.navigate().to("http://www.github.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).sendKeys("aleryanisilwan@gmail.com ");
        driver.findElement(By.id("password")).sendKeys("Silwan123456");
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/a[1]")).click();
        //driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("aleryanisilwan@gmail.com");
        //driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Silwan12456");
        //driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try
        {
            driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/a/span")).click();
            WebElement a1 = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/div[1]/strong"));
            System.out.println("---------Emaild exists --------------\n-----------------------");
            a1.sendKeys("ENTER CORRECT MAIL ID");
        }
        catch(Throwable e)
        {
            System.out.println("Email not found: " + e.getMessage());
        }

        driver.close();
    }
    // logout test
   @Test
    public  void logOut()
   {
       System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 30);
       driver.navigate().to("http://www.github.com/");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/a[1]")).click();
       driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("aleryanisilwan@gmail.com");
       driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Silwan123456");
       driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();
       driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/a/span")).click();
       driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/form/button")).click();
       WebElement el = driver.findElement(By.tagName("body"));
       Assert.assertTrue("title should start differently",
               el.getText().contains("Built for developers"));
       driver.close();
    }
    /*@Test
    public void login() {
        setText(By.id("user_login"), "aleryanisilwan@gmail.com")
                .setText(By.name("password"), "Silwan123456")
                .click(By.id("//*[@id=\\\"login\\\"]/form/div[4]/input[3]"))

                .validateTextPresent("You are now logged in");
    }*/
}
