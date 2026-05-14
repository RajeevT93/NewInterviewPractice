package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class NewWindow {

    public static void main(String[] args) {
        System.setProperty("window.edge.driver","C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();


       // driver.switchTo().newWindow(WindowType.WINDOW);
        //driver.switchTo().newWindow(WindowType.TAB);


        WebElement name = driver.findElement(By.className("form-control"));
        name.sendKeys("Rahul Shetty");
//        Set<String> handles = driver.getWindowHandles();
//        Iterator <String> it = handles.iterator();
//        String parentId = it.next();
//        String childId = it.next();
        System.out.println(name.getRect().getDimension().getHeight());
    }
}
