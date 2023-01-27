package p_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/oV91g");

        List<WebElement> el = driver.findElements(
                By.xpath("//*[contains(@class,'page_link')]"));

        for (int i = 0; i < el.size(); i++) {
            el.get(i).click();
            Thread.sleep(1000);
        }


        Thread.sleep(5000);
        driver.quit();
    }
}
//Napisti proram koji :
//Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//Hvatamo sve page-eve iz paginacije tabele
//Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//Izmedju iteracija napravite pauzu od 1s
//Zatvorite pretrazivac
