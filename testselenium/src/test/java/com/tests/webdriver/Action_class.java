package com.tests.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hemo on 6/4/2017.
 */
public class Action_class {
    static WebDriver driver;
    static Wait<WebDriver> wait;
    public static void main(String[] args) throws InterruptedException{
        dragdropgithub (  driver  );
        dragdropdrawio (driver);

    }
// i couldnt find drag and drop on github so i tried it with draw.io we used this page with other course
    public static void dragdropgithub ( WebDriver driver  ){
        driver= tests.SignIn();
        driver.navigate().to("https://github.com/GregoryMorse/AutoWebScriptIt/graphs/contributors?from=2017-03-14&to=2017-03-29&type=c");
        //driver.findElement(By.linkText("GregoryMorse/AutoWebScriptIt")).click();
        //driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div[2]/nav/div/button")).click();
        //driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div[2]/nav/div/div/div/a[2]")).click();

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"contributors-master\"]/svg/g/g[3]/rect[2]"));

        Actions action =new Actions(driver);
        action.dragAndDropBy(drag,50,0);
        //action.clickAndHold(drag).moveByOffset(10,50).perform();
        //action.clickAndHold(drag).dragAndDropBy(drag,100,2).perform();
       // action.dragAndDropBy(drag, 2,0).perform();

        //WebElement el= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/form/label/input[1]"));
        //el.sendKeys("GregoryMorse/AutoWebScriptIt");
        //el.submit();

        //driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[1]/div[2]/div/div[2]/a[3]")).click();

        //driver.navigate().to("https://github.com/GregoryMorse/AutoWebScriptIt/graphs/contributors?from=2017-03-14&to=2017-03-29&type=c");
        driver.quit();


    }
    public static void dragdropdrawio ( WebDriver driver  )throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:/Users/Hemo/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        Actions action= new Actions(driver);
        driver.get("https://www.draw.io/");

        driver.findElement(By.xpath("/html/body/div[13]/div/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement drag = driver.findElement(By.xpath("/html/body/div[4]/div[4]/div/a[1] "));
        WebElement drop = driver.findElement(By.xpath("/html/body/div[8]"));
        Thread.sleep(1000);
        action.dragAndDrop(drag,drop).perform();
        Thread.sleep(1000);
        // action.doubleClick(drag);
        // Thread.sleep(4000);
        action.contextClick(drag);
        Thread.sleep(4000);
        driver.quit();
    }
}
