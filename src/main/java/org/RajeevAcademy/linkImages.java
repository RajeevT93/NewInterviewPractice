package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.overlay.model.LineStyle;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class linkImages {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);


        WebElement header = driver.findElement(By.xpath("//span[text()='Electronics']"));
        WebElement subbHeader = driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
        //WebElement subHeader = driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']"));
       // List <WebElement> img = driver.findElements(By.xpath("//div[@data-id='DLLGVCS9ZPVA3JT5']//img"));
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions a = new Actions(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(header));
        a.moveToElement(header).build().perform();
        //header.click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='_1BJVlg _11MZbx']")));


        //Thread.sleep(3000);
        a.moveToElement(subbHeader).click().build().perform();
    }

}
//a[@class='_1BJVlg _11MZbx']