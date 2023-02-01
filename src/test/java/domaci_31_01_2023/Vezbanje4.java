package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Vezbanje4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        List<String> imgLinks = new ArrayList<>();
        imgLinks.add("images/front.jpg");
        imgLinks.add("images/right.jpg");
        imgLinks.add("images/left.jpg");
        imgLinks.add("images/back.jpg");

        for (int i = 0; i < imgLinks.size(); i++) {
            driver.findElement(By.xpath("//input[@type='file']"))
                    .sendKeys(new File(imgLinks.get(i)).getAbsolutePath());
            Thread.sleep(1000);

        }

        driver.findElement(By.cssSelector(".start")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak (za vezbanje)
//Napisati program koji:
//●	Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//●	Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//●	Ceka da se prikazu 4 item-a a upload
//●	Klik na upload
//●	Ceka da se upload zavrsi