package domaci26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje
// odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
public class Zadatak3 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://s.bootsnipp.com/iframe/Dq2X");
    List<WebElement> dugmici = new ArrayList<>(driver.findElements(By.xpath("//button")));
    //    dugmici.forEach(WebElement::click);
    //    dugmici = driver.findElements(By.xpath("//button"));
    //    driver.quit();
    //    System.out.println("Broj elemenata koji nisu izbrisani: " + dugmici.size());
    //Ah, ovo bi bilo tako lako da ne mora posle svakog klika da se gleda...
    int temp = dugmici.size() - 1;
    //unazad
    //    for (int i = temp; i >= 0; i--) {
    //        dugmici.get(i).click();
    //        try {
    //            if (!dugmici.get(i).equals(driver.findElement(By.xpath("(//button)[last()]")))) {
    //                System.out.println("Element je izbrisan!");
    //                dugmici.remove(i);
    //            }
    //        } catch (NoSuchElementException e) {
    //            System.out.println("Element je izbrisan!");
    //            dugmici.remove(i);
    //        }
    //    }
    //unapred
    for (int i = temp; i >= 0; i--) {
        dugmici.get(0).click();
        try {
            if (!dugmici.get(0).equals(driver.findElement(By.xpath("(//button)[1]")))) {
                System.out.println("Element je izbrisan!");
                dugmici.remove(0);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element je izbrisan!");
            dugmici.remove(0);
        }
    }
    driver.quit();
    //Iskreno, od pocetka mi je bilo lakse odozgo da se brise.
}
}
