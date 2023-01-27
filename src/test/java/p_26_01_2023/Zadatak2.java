package p_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

//        List<WebElement> el = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> el = driver.findElements(By.xpath("//div[contains(@id, 'lorem')]//tr/td[1]"));


        for (int i = 0; i < el.size(); i++) {
            System.out.println(el.get(i).getText());
            Thread.sleep(1000);
        }


        Thread.sleep(3000);
        driver.quit();

    }
}

//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa.
// Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac
//Stampa treba da bude kao u primeru:
//John
//Mary
//July