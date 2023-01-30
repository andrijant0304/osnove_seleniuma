package domaci_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

//        driver.findElement(By.id("basic-primary-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-secondary-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-success-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-danger-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-warning-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-info-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-light-trigger")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("basic-dark-trigger")).click();
//        Thread.sleep(1000);

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@id='section-basic-example']/section[1]//button"));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak
//●	Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//●	Klik na svako dugme od PRIMARY do DARK
//●	Sacekati da se toasts u desnom gornjem uglu pojavi
//●	Pauza izmedju klikova 1s
//●	Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s