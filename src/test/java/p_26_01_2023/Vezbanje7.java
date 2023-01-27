package p_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Vezbanje7 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(2000, 5000));

        driver.get("https://netoglasi.rs/");

//        List<WebElement> element = driver.findElements(By.xpath("//app-category-picker-item//a/text()"));
//        List<WebElement> element = driver.findElements(By.xpath("//app-category-picker-item"));
//        List<WebElement> element = driver.findElements(By.tagName("//a[contains(@class, 'subcategory')]"));

        List<WebElement> element = driver.findElements(By.xpath("//app-category-picker-item//a"));
        Actions actions = new Actions(driver);


        for (int i = 0; i < element.size()-1; i++) {

            System.out.println(element.get(i).getText());

           if (element.indexOf(i) < element.size()){
               actions.moveToElement(element.get(i+1));
               actions.perform();
           }
            Thread.sleep(300);
        }

        System.out.println();

        if (element.get(0).getText().equals("Automobili")){
            System.out.println("Kategorija 'Automobili' je na prvom mestu");
        } else {
            System.out.println("Kategorija 'Automobili' nije na prvom mestu");
        }

        driver.findElement(By.xpath("//app-category-picker-item//a[contains(text(), 'Automobili')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}

//Zadatak (ZA VEZBANJE)
//Ucitati stranicu https://netoglasi.rs/
//Ispisati sve nazive kategorija iz leve navigacije
//Validirati da je kategorija Automobili na prvom mestu
//Klik na kategoriju Automobili
//Validarati da je kategorija Automobili izbacena iz liste.