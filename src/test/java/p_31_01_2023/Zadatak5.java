package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://cms.demo.katalon.com/");
//        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.xpath("//*[@id='primary-menu']//a"));

        for (int i = 0; i < links.size(); i++) {
            String href = links.get(i).getAttribute("href");
            System.out.println(href);

            URL url = new URL(href);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            System.out.println(http.getResponseCode());
        }




        driver.quit();
    }
}

//Napisati program koji:
//Ucitava stranicu https://cms.demo.katalon.com/
//Hvata  sve href atribute svih linkova iz navigacije
//Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//Koristan link za citanje status koda nekog url-a

