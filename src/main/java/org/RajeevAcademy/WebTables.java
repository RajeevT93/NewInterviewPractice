package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;

public class WebTables {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor  js = (JavascriptExecutor) driver;



        js.executeScript("window.scrollBy(0,800)");


        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> headers = driver.findElements(By.xpath("//fieldset/div/table/thead/tr"));
        for (int i=0; i<headers.size(); i++) {
            System.out.println(headers.get(i).getText());
        }
        List <WebElement> numbers = driver.findElements(By.xpath("//fieldset/div/table/tbody/tr/td[4]"));
       int sum =0;
        for (int j=0; j<numbers.size(); j++) {
             sum = sum + Integer.parseInt(numbers.get(j).getText());
            //System.out.println(numbers.get(j).getText());
        }


        System.out.println(sum);

        String totalSum = driver.findElement(By.cssSelector(".totalAmount")).getText();

        String[] totalSumm = totalSum.split(":");

        String total = totalSumm[1].trim();
        System.out.println(total);

    }
}
