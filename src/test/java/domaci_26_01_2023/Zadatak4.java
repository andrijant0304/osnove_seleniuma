package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://geodata.solutions/");

        Select country = new Select(driver.findElement(By.id("countryId")));
        Thread.sleep(1000);
//        country.selectByVisibleText("Serbia");
        country.selectByValue("Serbia");
        Thread.sleep(1000);

        Select state = new Select(driver.findElement(By.id("stateId")));
        Thread.sleep(1000);
//        state.selectByVisibleText("Central Serbia");
        state.selectByValue("Central Serbia");
        Thread.sleep(1000);

        Select city = new Select(driver.findElement(By.id("cityId")));
        Thread.sleep(1000);
//        city.selectByVisibleText("Nis");
        city.selectByValue("Nis");

        Thread.sleep(3000);
        driver.quit();
    }
}

//.Zadatak
//●	Napisati program koji ucitava stranicu https://geodata.solutions/
//●	Bira Country, State i City po vasoj zelji
//●	Pritom potrebno je izvrsiti cekanje da se pojave State-ovi nakon izbora Country-a
//●	I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//●	Izabrerite Country, State i City tako da imate podatke da selektujete!