package com.tests.webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hemo on 6/4/2017.
 */
public class downloadUploadfile {
    static WebDriver driver;
    static Wait<WebDriver> wait;
    public static void main(String[] args) throws InterruptedException, IOException {
        download (  driver  );
        upload (driver);

    }
    // download
    public static void download(WebDriver driver) {
        driver=tests .SignIn();
        driver.get("https://github.com/JacksonFurrier/Software-quality-and-testing");
        driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[4]/div[1]/button/span")).click();
        WebElement downloadButton = driver.findElement(By
                .xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[4]/div[1]/div/div/div[3]/a[2]"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P E:\\filefromselenium --no-check-certificat https://github.com/" + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        driver.close();

    }
    // upload file
    public static  void upload(WebDriver driver){
        driver=tests.SignIn();
        driver.get("https://github.com/settings/profile");
        //driver.findElement(By.className("header-nav-link name tooltipped tooltipped-sw js-menu-target")).click();
        //driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/div/div/a[5]")).click();

        WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"profile_25897335\"]/dl/dd/div/label/input"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\Hemo\\Downloads\\Swan.jfif");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // check the "I accept the terms of service" check box
        //driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        WebElement el =driver.findElement(By.name("op"));
        el.submit();
      //  driver.findElement(By.xpath("//*[@id=\"facebox\"]/div/div/form/div[3]/button")).click();


    }
}
