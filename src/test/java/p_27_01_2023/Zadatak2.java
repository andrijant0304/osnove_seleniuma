package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("file:///C:/HTML%201/IT%20Bootcamp/IT%20Bootcamp%202022/Nastava/9.%20nedelja%20-%20Selenium/predavanja/Zadatak4.html");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
//            driver.findElements(By.id("id-" + i));
            driver.findElements(By.xpath("//body/div[" + (i+1) + "]"));
//            driver.findElements(By.xpath("//body/div[last() + 1]"));          ne moze ovako

        }

        Thread.sleep(3000);
        driver.quit();
    }
}

//Napisati program koji ucitava stranicu Zadatak4.html
//Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom
// na fajl i Downloads-a i ikopirajte url. To je url za get u programu
//I na stranici dodaje 5 poruka “IT Bootcamp”
//Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//Sacekati da se novi element pojavi pre nego sto se doda sledeci