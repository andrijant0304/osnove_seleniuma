package domaci__02_02_2023;

import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {

    private WebDriver driver;
    private WebDriverWait wait;
    String  baseUrl = "https://s.bootsnipp.com";
    String firstName = "Andrija";
    String lastName = "Antic";
    String middleName = "Zoran";


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get(baseUrl + "/iframe/K5yrx");
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    @Description("Test #1: Edit Row")
    public void  editRow() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com");

        driver.findElement(By.cssSelector("#d1 .update")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));

        driver.findElement(By.cssSelector("#fn")).clear();
        driver.findElement(By.cssSelector("#fn")).sendKeys(firstName);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#ln")).clear();
        driver.findElement(By.cssSelector("#ln")).sendKeys(lastName);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#mn")).clear();
        driver.findElement(By.cssSelector("#mn")).sendKeys(middleName);
        Thread.sleep(500);

        driver.findElement(By.cssSelector("#up")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-content")));

        Assert.assertTrue(driver.findElement(By.cssSelector("#f1")).getText().contains(firstName), "Invalid first name" );
        Assert.assertTrue(driver.findElement(By.cssSelector("#l1")).getText().contains(lastName), "Invalid last name");
        Assert.assertTrue(driver.findElement(By.cssSelector("#m1")).getText().contains(middleName), "Invalid middle name" );
    }

    @Test(priority = 2)
    @Description("Test #2: Delete Row")
    public void deleteRow() throws IOException {

        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com");

        List<WebElement> rows = driver.findElements(By.cssSelector("#d1 .delete"));

        driver.findElement(By.cssSelector("#d1 .delete")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(".modal-content"))));

        driver.findElement(By.cssSelector(".modal-footer .btn-danger")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-content")));

        List<WebElement> rowsAfterDelete = driver.findElements(By.cssSelector("#d1 .delete"));
        Assert.assertEquals(rowsAfterDelete.size(),rows.size()-1, "Table element is not deleted");
    }

    @Test(priority = 3)
    @Description("Test #3: Take a Screenshot")
    public void takeAScreenshotOfWebPage(){

        try {
            new Helper()
                    .takeScreenshot(driver,
                            "screenshots/" + driver.getTitle() + ".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png