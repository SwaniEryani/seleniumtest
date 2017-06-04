package com.tests.webdriver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hemo on 5/31/2017.
 */
public class tests {
    static WebDriver driver;
    static Wait<WebDriver> wait;
// create the driver
    public static WebDriver settingdriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.github.com/");
        return driver;

    }
    // test signin link
    @Test

    public void testSignInlink () {

        driver = settingdriver();
        driver.findElement(By.linkText("Sign in")).click();
       // WebElement el = driver.findElement(By.tagName("body"));
        Assert.assertTrue("title should start differently",
                driver.getTitle().startsWith("Sign in to GitHub · GitHub"));
        driver.close();
    }
    // test sing up link
    @Test

    public void testSignUplink () {

        driver = settingdriver();
        driver.findElement(By.linkText("Sign up")).click();
        Assert.assertTrue("title should start differently",
                driver.getTitle().equals("Join GitHub · GitHub"));
        driver.close();
        /*WebElement el = driver.findElement(By.tagName("body"));
        boolean result;
        try {
            result = el.getText().contains("Join GitHub");
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
*/
       // assertEquals("Page body header match failed", "Join GitHub", bodyHeader.getText());

    }
    public static WebDriver SignIn () {

        driver = settingdriver();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).sendKeys("aleryanisilwan@gmail.com ");
        driver.findElement(By.id("password")).sendKeys("Silwan123456");
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();
        return driver;
    }
    public void SignOut () {
        driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[2]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[2]/div/div/form/button")).click();
        driver.close();
    }
    @Test
// test dropdown list
    public void dropDownlistTest() {
        driver = SignIn();
        driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[1]/div[1]/button")).click();
        //select from dropdown list
        driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[1]/div[1]/div/div/div[3]/a[2]/span")).click();
      //  WebElement el = driver.findElement(By.tagName("body"));
        System.out.println(driver.getTitle());
        Assert.assertTrue("title should start differently",
                driver.getTitle().contains("Sign up your team"));
       //SignOut();
    }
    // test dropdown list
    @Test
    public void dropdownCaret() {
        driver = SignIn();
        driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[2]/a/span")).click();
        //select from dropdown list
        driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[2]/div/ul/a[3]")).click();
        //System.out.println(driver.getTitle()) ;
        //WebElement el = driver.findElement(By.tagName("body"));
        Assert.assertTrue("title should start differently",
               driver.getTitle().contains("Create a new Gist"));
        SignOut();
    }
    //Create an Explicit wait.
    @Test
    public void explicitWait() {
        driver = SignIn();
        WebDriverWait myWait2 = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/a")).click();
        myWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/div[1]/strong")));
        WebElement chkFBPersist = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/div[1]/strong"));
        /*for (int i = 0; i < 2; i++) {
            chkFBPersist.click();
            System.out.println(chkFBPersist.isSelected());
        }*/
        WebElement el= driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/div[1]/strong"));
        boolean result;
        try {
            result = el.getText().contains("SwaniEryani");
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
        /*
        Assert.assertTrue("title should start differently",
                el.getText().contains("SwaniEryani"));
        */
        driver.quit();
    }

    @Test
    //Back Button
    public void BackButton(){
        driver =SignIn();
        driver.get("https://github.com/pulls");
        driver.navigate().back();
        Assert.assertTrue("title should start differently",
                driver.getTitle().equals("GitHub"));
        driver.close();

    }

}
