package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Vezbanje2 {
    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);

        System.out.print("Unesite matematicki izraz: ");
        String izraz = s.next();

        GetTheString convert = new GetTheString();
        List<Character> izrazLista = convert.convertStringToCharList(izraz);     // Get the List of Character
        System.out.println(izrazLista);                                        // Print the list of characters

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        Thread.sleep(10000);
        WebElement one = driver.findElement(By.name("cs_one"));
        WebElement two = driver.findElement(By.name("cs_two"));
        WebElement three = driver.findElement(By.name("cs_three"));
        WebElement four = driver.findElement(By.name("cs_four"));
        WebElement five = driver.findElement(By.name("cs_five"));
        WebElement six = driver.findElement(By.name("cs_six"));
        WebElement seven = driver.findElement(By.name("cs_seven"));
        WebElement eight = driver.findElement(By.name("cs_eight"));
        WebElement nine = driver.findElement(By.name("cs_nine"));
        WebElement zero = driver.findElement(By.name("cs_zero"));

        WebElement multiply = driver.findElement(By.name("cs_multiply"));
        WebElement divide = driver.findElement(By.name("cs_divide"));
        WebElement subtract = driver.findElement(By.name("cs_subtract"));
        WebElement add = driver.findElement(By.name("cs_add"));
        WebElement equal = driver.findElement(By.name("cs_equal"));

        for (int i = 0; i < izrazLista.size(); i++) {
            if(izrazLista.get(i).equals('0'))zero.click();
            if(izrazLista.get(i).equals('1')) one.click();
            if(izrazLista.get(i).equals('2'))two.click();
            if(izrazLista.get(i).equals('3'))three.click();
            if(izrazLista.get(i).equals('4'))four.click();
            if(izrazLista.get(i).equals('5'))five.click();
            if(izrazLista.get(i).equals('6'))six.click();
            if(izrazLista.get(i).equals('7'))seven.click();
            if(izrazLista.get(i).equals('8'))eight.click();
            if(izrazLista.get(i).equals('9'))nine.click();

            Thread.sleep(1000);
            if(izrazLista.get(i).equals('*'))multiply.click();
            if(izrazLista.get(i).equals('/'))divide.click();
            if(izrazLista.get(i).equals('+'))add.click();
            if(izrazLista.get(i).equals('-'))subtract.click();
            if(izrazLista.get(i).equals('='))equal.click();
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak (Za vezbanje)
//Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//●	Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//●	Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//○	1243+329=
//○	21912-4=
//○	12913÷4=
//●	U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere.
// Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//●	Zatim u odnosu na karakter uradite odredjenu logiku
