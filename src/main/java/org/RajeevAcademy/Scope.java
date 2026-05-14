package org.RajeevAcademy;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;



        js.executeScript("window.scrollBy(0,2000)");


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        for (int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it =  abc.iterator();


        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
//table/tbody/tr/td/ul/li/a