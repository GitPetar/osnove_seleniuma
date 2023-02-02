package p31_01_2023;
//Napisati program koji:
//Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Zadatak2 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://blueimp.github.io/jQuery-File-Upload/");
    driver.findElement(By.name("files[]")).sendKeys(new File("test_data/slika.jpg").getAbsolutePath());
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 1));
    driver.findElement(By.xpath("(//button[contains(@class,'btn btn-primary start')])[2]")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@data-type='DELETE'])")));
    driver.findElement(By.xpath("(//button[@data-type='DELETE'])")).click();
    wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 0));
    
    driver.quit();
}
}
