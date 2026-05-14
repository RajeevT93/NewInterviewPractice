package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");




        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set <String> windows = driver.getWindowHandles();
        Iterator <String> it =  windows.iterator();


        String parentId = it.next();
        String childId  = it.next();
        driver.switchTo().window(childId);
        String Text = driver.findElement(By.xpath("//div/p[2]")).getText().split("@")[1].trim().split(" ")[0];
        System.out.println(Text);
        driver.switchTo().window(parentId);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));


        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//*[@id='login-form']/div[4]/div/label[2]/span[2]")).click();
        Thread.sleep(5000);

        //driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        Thread.sleep(3000);
        WebElement staticDropDown = driver.findElement(By.cssSelector(".form-group select"));

        Select dropDown = new Select(staticDropDown);
        dropDown.selectByVisibleText("Consultant");
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#signInBtn")).click();
    }
}
//*[@id="login-form"]/div[4]/div/label[1]/span[2]
//*[@id="login-form"]/div[5]/select