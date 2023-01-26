package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://artplayer.org/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@aria-label='Mute']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[@class='art-icon art-icon-screenshot']")).click();
//        driver.findElement(By.xpath("//*[contains(@class, 'screenshot')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-pip')]")).click();
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-pip']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class='art-icon art-icon-pip']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenWebOn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenWebOff']")).click();

        Thread.sleep(2000);

        Thread.sleep(5000);
        driver.quit();

    }
}

//5.	Zadatak
//●	Maksimizirati prozor
//●	Ucitati stranicu https://artplayer.org/
//○	U fokusu je player sa desne strane
//●	Ceka 3-4s
//●	Klik na play dugme
//●	Klik na na zvucnik za mute
//●	Ceka 3s
//●	Klik na screenshot
//●	Klik na PIP mode
//●	Ceka 1s
//●	Klik na Exit PIP mode
//●	Klik na WebFullscreen
//●	Klik na Exit WebFullscreen
//●	Cekanje od 5s
//●	Zatvorite pretrazivac