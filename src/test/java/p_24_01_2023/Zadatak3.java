package p_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();




        ArrayList<String> websites = new ArrayList<>();
        websites.add("https://google.com/");
        websites.add("https://youtube.com/");
        websites.add("https://www.ebay.com/");
        websites.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < websites.size(); i++) {
            driver.get(websites.get(i));
            Thread.sleep(1000);

            System.out.println(driver.getTitle());
            System.out.println(websites.get(i));
            System.out.println();
        }


        Thread.sleep(5000);
        driver.quit();
    }
}

//3.Zadatak
//Napisati program koji ima:
//Niz stranica (niz stringova) koje treba da ucita. Niz je:
//https://google.com/
//https://youtube.com/
//https://www.ebay.com/
//https://www.kupujemprodajem.com/
//Program petljom prolazi kroz niz stranica i svaku stranicu ucitava
// preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice.
// Kako od stranice procitati naslov imate na ovom linku
//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem
//Zatvara pretrazivac