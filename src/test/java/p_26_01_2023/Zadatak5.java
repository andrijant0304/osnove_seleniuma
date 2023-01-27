package p_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

//  radi samo za 'select' element

        Select select = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));

        select.selectByVisibleText("Crafts");


        Thread.sleep(3000);
        driver.quit();

    }
}
//Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//
//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”