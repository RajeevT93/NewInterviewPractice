package org.RajeevAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;


public class practiceNew {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        WebDriver driver = new EdgeDriver();

        //System.getProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();





        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        List<WebElement> countryNames = driver.findElements(By.className("ui-menu-item-wrapper"));
//        Thread.sleep(3000);
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

//        for (WebElement country : c) {
//            country.sendKeys("Ind");
//            Thread.sleep(3000);
//            if(driver.findElement(By.className("ui-menu-item-wrapper")).equals("India")) {
//
//            }
//        }


        for (WebElement country : countryNames) {
            if (country.getText().equalsIgnoreCase("India"));
            {
                country.click();

                break;
            }
        }
    }
}
