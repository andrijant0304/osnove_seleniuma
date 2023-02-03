package domaci_31_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("slider_bkgd"))).perform();

        List<WebElement> srcList = driver.findElements(By.xpath("//*[@class='carousel-item']/img"));
        for (int i = 0; i < srcList.size(); i++) {
          String srcLink = srcList.get(i).getAttribute("src");

            URL url = new URL(srcLink);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            if (http.getResponseCode() >= 200 && http.getResponseCode() < 400) {
                System.out.println("Link: " + url + " is available.");

            } else {
                System.out.println("Link: " + url + " is not available.");
            }

            try {
                new Helper().downloadUsingStream(srcLink, "itbootcamp_slider/0"+ i + ".jpg");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak
//Napisati program koji:
//●	Ucitava stranicu https://itbootcamp.rs/
//●	Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//●	Cita sve linkove slika iz slajdera
//●	Proverava url svake slike, i za sve slike koje imaju status
// veci i jednak od 200 a manji od 300, skida i smesta
// u folder itbootcamp_slider u okviru projekta
//●	Azurirajte gitignore da ignorise itbootcamp_slider folder