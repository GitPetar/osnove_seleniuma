package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//3.Zadatak
//Napisati program koji
//ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik Primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Ceka da se izgubi toasts u gornjem desnom uglu
//Ispisuje da se elment izgubio
//Klik na primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Klik na x dugme iz toasts-a
//Ceka da se element izgubi
//Ispisuje da se element izgubio
public class Zadatak3 {
public static void main(String[] args) throws InterruptedException {
    //
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
    WebElement primary = driver.findElement(By.xpath("//button[contains(text(),'Primary')]"));
    WebElement tost = driver.findElement(By.xpath("//div[contains(text(),'Primary')]"));
    WebElement dugmeTosta = tost.findElement(By.xpath("./..//button"));
    
    primary.click();
    wait.until(ExpectedConditions.visibilityOf(tost));
    System.out.println("Tost se pojavio.");
    wait.until(ExpectedConditions.invisibilityOf(tost));
    System.out.println("I u trenu nestao...");
    primary.click();
    wait.until(ExpectedConditions.visibilityOf(tost));
    System.out.println("Evo ga opet!");
    dugmeTosta.click();
    wait.until(ExpectedConditions.invisibilityOf(tost));
    System.out.println("Kliknuli smo mu na dugme i nestao je.");
    Thread.sleep(3000);
    driver.quit();
}
}
