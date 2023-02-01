package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
//        driver.manage().window().maximize();

//        String urlStr = driver.findElement(By.xpath("//figure/div[1]/a")).getAttribute("href");
//        String file = new File("src/test/downloads").getAbsolutePath();
//        System.out.println(driver.findElement(By.xpath("//figure/div[1]/a")).getAttribute("href"));


//            URL url = new URL(urlStr);
//            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//            fos.close();
//            rbc.close();


        String imgSrc = driver.findElement(By.className("zoom-img")).getAttribute("src");





//        driver.quit();
    }
}

//Napisati program koji
//Kreirati folder downloads u projektu
//Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
//Cita href atribut sa glavne slike sa stranice
//Koristi link iz href atributa za skidanje slike
//Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
//Koristan link za skidanje fajlova u javi
//Azurirajte gitignore da ignorise downloads folder