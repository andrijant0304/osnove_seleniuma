package domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".clean-btn.toggleButton_rCf9")).click();

        String theme = driver.findElement(By.tagName("html")).getAttribute("data-theme");
//        if (theme.equals(theme)) System.out.println("Tema je " + theme);
        if (theme.equals("light")){
            System.out.println("Tema je 'light'");
        } else {
            System.out.println("Tema je 'dark'");
        }
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".clean-btn.toggleButton_rCf9")).click();

        String theme2 = driver.findElement(By.tagName("html")).getAttribute("data-theme");
//        if (theme2.equals(theme2)) System.out.println("Tema je " + theme2);
        if (theme2.equals("light")){
            System.out.println("Tema je 'light'");
        } else {
            System.out.println("Tema je 'dark'");
        }
        Thread.sleep(1000);

        new Actions(driver).keyDown(Keys.CONTROL)
                            .sendKeys("k")
                            .keyUp(Keys.CONTROL)
                            .perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Input")))
                .getAttribute("type");

        System.out.println("Atribut input polja je: " +
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Input")))
                .getAttribute("type"));

        driver.quit();
    }
}

//3.	Zadatak
//Napisati program koji:
//●	Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//●	Implicitno cekanje za trazenje elemenata je maksimalno 10s
//●	Implicitno cekanje za ucitavanje stranice je 5s
//●	Ucitava stranicu https://docs.katalon.com/
//●	Maksimizuje prozor
//●	Od html elementa cita data-theme atribut.
//●	Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//●	Klikce na dugme za zamenu tema
//●	Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//●	Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//●	Ceka da se dijalog za pretragu pojavi
//●	Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//●	Zatvara pretrazivac