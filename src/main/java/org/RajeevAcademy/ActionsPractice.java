package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();




        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"));


        a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("h").keyUp(Keys.SHIFT).sendKeys("ello").doubleClick().build().perform();
    }
}
