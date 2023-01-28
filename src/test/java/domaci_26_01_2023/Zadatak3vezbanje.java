package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3vezbanje {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> buttons = driver.findElements(By.className("close"));
        for (int i = 0; i < buttons.size(); i++) {
            driver.findElement(By.xpath("(//button[@class='close'])[last()]")).click();
            Thread.sleep(500);
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

//Napisati program koji:
//●	Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//●	Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika
// element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//●	POMOC: Brisite elemente odozdo.
//●	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo