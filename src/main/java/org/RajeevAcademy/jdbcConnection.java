package org.RajeevAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.*;

public class jdbcConnection {


    public static void main(String[] args) throws SQLException, InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        String host = "localhost";
        String port = "3306";



        Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/practicedbt","root","Rajeev@658993");

        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'sam';");


        while (rs.next()) {
            driver.get("https://www.facebook.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.id("email")).sendKeys(rs.getString("location"));
            driver.findElement(By.id("pass")).sendKeys(rs.getString("name"));
        }
    }
}
