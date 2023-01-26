package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList database = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@class='btn btn-info add-new']")).click();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[@class='btn btn-info add-new']")).click();
            Thread.sleep(1000);

            driver.findElement(By.name("name")).sendKeys("Andrija A");
            Thread.sleep(1000);

            driver.findElement(By.name("department")).sendKeys("QA");
            Thread.sleep(1000);

            driver.findElement(By.name("phone")).sendKeys("(381)116-2222");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//tbody/tr[last()]/td[4]/a[1]")).click();
            Thread.sleep(1000);
        }

        Thread.sleep(2000);
        driver.quit();
        
    }
}

//4.	Zadatak
//Napisati program koji vrsi dodavanje 5 redova
//●	Maksimizirati prozor
//●	Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//●	Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//●	Klik na dugme Add New
//●	Unesite name,departmant i phone (uvek iste vrednost)
//i.	Trazenje po name atributu
//ii.	Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit,
// add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje,
// a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//iii.	Cekanje od 0.5s
//●	Na kraju programa ugasite pretrazivac.