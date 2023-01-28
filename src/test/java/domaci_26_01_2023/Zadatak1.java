package domaci_26_01_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

//        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        List<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");

        for (int i = 0; i < todos.size(); i++) {

//        driver.findElement(By.className("new-todo")).sendKeys(todos.get(i) + "\n");

            driver.findElement(By.className("new-todo")).sendKeys(todos.get(i) + Keys.ENTER);
            Thread.sleep(1500);
            System.out.println(todos.get(i));
            if (todos.get(i).equals(driver.findElement(
                    By.xpath("//li[last()]//div[@class='view']/label")).getText())) {
                System.out.println("Unet je novi toDo :)");
            }

        }

        List<WebElement> liElements = driver.findElements(By.xpath("//li//div[@class='view']"));

        for (int i = 0; i < liElements.size(); i++) {
//            WebElement liLink = driver.findElement(By.xpath("//li[last()]//div[@class='view']"));
            WebElement liLink = driver.findElement(By.xpath("(//li[last()])//div[@class='view']"));
            actions.moveToElement(liLink);
            actions.perform();

            driver.findElement(By.xpath("(//li[last()])//button[contains(@class,'destroy')]")).click();
            Thread.sleep(1000);
        }



        Thread.sleep(5000);
        driver.quit();
    }
}

//●	Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//○	Visit Paris
//○	Visit Prague
//○	Visit London
//○	Visit New York
//○	Visit Belgrade
//●	Maksimizirati prozor
//●	Ucitati stranicu https://example.cypress.io/todo
//●	Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//○	Nakon svakog unosa todo-a, unosi se enter
//○	Validira da li je novi todo dodat na stranici
//●	Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//●	Validirati da je na kraju programa broj todo-a na stranici 0.
//●	Cekanje od 5s
//●	Zatvorite pretrazivac