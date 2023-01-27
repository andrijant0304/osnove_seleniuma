package p_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

//        List<WebElement> el = driver.findElements(By.xpath("//div[contains(@id, 'lorem')]//tr"));
//
//        for (int i = 1; i < el.size(); i++) {
//            System.out.println(el.get(i).getText());
//            Thread.sleep(1000);
//        }

//        List<WebElement> el = driver.findElements(By.xpath("//div[contains(@id, 'lorem')]//tr"));
//
//        for (int i = 1; i < el.size(); i++) {
//
//            List<WebElement> eltd = driver.findElements(By.xpath("//div[contains(@id, 'lorem')]//tr/td"));
//
//            System.out.print(el.get(i).getText() + " ");
//            Thread.sleep(1000);
//
//            for (int j = 0; j < el.size(); j++) {
//                System.out.println();
//            }
//        }

        WebElement table =
                driver.findElement(By.xpath("//*[@id='lorem']/table"));

        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < columns.size(); j++) {
                System.out.print(columns.get(j).getText() + "\t");
            }
            System.out.println();

        }


        Thread.sleep(2000);
        driver.quit();
    }
}
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 5s
//Zatvara pretrazivac
//Stampa treba da bude kao u primeru:
//John	Doe	john@example.com
//Mary	Moe	mary@example.com
//July	Dooley	july@example.com
//
//HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...
