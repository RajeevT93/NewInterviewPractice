package org.RajeevAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;

public class DatePicker {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\rajee\\Downloads\\edgedriver\\msedgedriver.exe");

        driver = new EdgeDriver();

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        selectDate("14", "August", "2025");

    }



    public static void selectDate(String targetDate, String targetMonth, String targetYear) {
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("datepicker")).click();

        while (true) {
            String dispMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String dispYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (targetMonth.equals(dispMonth) && targetYear.equals(dispYear)) {
                break;
            }

            if (isMonthYearLater(targetMonth, targetYear, dispMonth, dispYear)) {
                WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
                next.click();
            }
            else {
                WebElement prev = driver.findElement(By.xpath("//span[text()='Prev']"));
                prev.click();
            }
        }
        WebElement date = driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+targetDate+"']"));
        date.click();
    }
        public static boolean isMonthYearLater (String targetMonth, String targetYear, String dispMonth, String dispYear)
        {
            int targetYearInt = Integer.parseInt(targetYear);
            int dispYearInt = Integer.parseInt(dispYear);
            if (targetYearInt > dispYearInt) {
                return true;
            }
            else if (targetYearInt < dispYearInt) {
                return false;
            }

            Map<String, Integer> monthMap = new HashMap<>();
            monthMap.put("January", 1);
            monthMap.put("February", 2);
            monthMap.put("March", 3);
            monthMap.put("April", 4);
            monthMap.put("May", 5);
            monthMap.put("June", 6);
            monthMap.put("July", 7);
            monthMap.put("August", 8);
            monthMap.put("September", 9);
            monthMap.put("October", 10);
            monthMap.put("November", 11);
            monthMap.put("December", 12);

            int targetMonthIndex = monthMap.get(targetMonth);
            int dispMonthIndex = monthMap.get(dispMonth);
            return targetMonthIndex > dispMonthIndex;
        }

}
