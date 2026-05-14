package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SoftAssertion {

    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.edge.driver", "C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");


        driver.manage().window().maximize();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,2000)");
//        SoftAssert a = new SoftAssert();
        //List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String Stringurl = link.getAttribute("href");

            if (Stringurl!=null && !Stringurl.isEmpty()){
                URL url = new URL(Stringurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("HEAD");
                conn.setConnectTimeout(2000);
                conn.setReadTimeout(2000);


                conn.connect();
                int ResponseCode = conn.getResponseCode();
                if (ResponseCode >= 400) {
                    System.out.println(url + "not valid");
                }
                else{
                    System.out.println(url + " " + "Valid url");
                }
            }


        }
    }
}
