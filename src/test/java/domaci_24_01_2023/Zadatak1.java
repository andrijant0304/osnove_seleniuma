package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

        Thread.sleep(10000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='oxd-layout-context']//button")).click();
//        driver.findElement(By.xpath("//*[@class='oxd-layout-context']//button")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()= 'Logout']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}

//1.	Zadatak
//●	Maksimizirati prozor
//●	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//●	Prijavite se na sistem
//○	Username: Admin
//○	Password: admin123
//●	Cekanje od 5s
//●	U input za pretragu iz navigacije unesite tekst Me
//●	Kliknite na prvi rezultat pretrage (to ce biti Time)
//●	Cekanje od 1s
//●	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//●	Klinkite na logout
//●	Cekanje od 5s
//●	Zatvorite pretrazivac