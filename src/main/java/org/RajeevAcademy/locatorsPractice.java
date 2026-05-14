package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class locatorsPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");



        driver.manage().window().maximize();
        WebElement UserName = driver.findElement(By.id("inputUsername"));
        UserName.sendKeys("Rahul Shetty");
        WebElement pasword = driver.findElement(By.cssSelector("input[placeholder='Password']"));


        pasword.sendKeys("Rahul@123");
        driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'chkboxTwo')]")).click();


        driver.findElement(By.xpath("//button[starts-with(@type,'submit')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector(".forgot-pwd-container")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Name')]")).sendKeys("Rahul Shetty");
        driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("RahulShetty9989@gmal.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String Text = driver.findElement(By.cssSelector(".infoMsg")).getText();
        System.out.println(Text);
        String[] text = Text.split("'");


        String password = text[1].split("'")[0];
        System.out.println(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        UserName.sendKeys("Rahul");

        pasword.sendKeys(password);

        driver.findElement(By.xpath("//button[starts-with(@type,'submit')]")).click();
    }
}
