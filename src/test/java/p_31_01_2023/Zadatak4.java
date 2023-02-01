package p_31_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.time.Duration;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Zadatak4 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();


        TakesScreenshot ts=(TakesScreenshot)driver;

        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("screenshots/screenshot01.jpg"));
//            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("screenshots\\Screenshot.png"));
        } catch (WebDriverException e) {

        } catch (IOException e) {

        }

        driver.quit();
    }
}

//Napisati program koji:
//Kreirati screenshots folder u projektu
//Ucitava stranicu https://cms.demo.katalon.com/
//Kreira screenshot stranice
//Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//Koristan link 1. LAKSE CE VAM BITI PREKO OVOG
//Koristan link 2