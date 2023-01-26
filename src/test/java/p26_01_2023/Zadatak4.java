package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//4. Zadatak
//Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.
public class Zadatak4 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://cms.demo.katalon.com/my-account/");
    Thread.sleep(2000);
    WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
    checkbox.click();
    if (checkbox.isSelected()) {
        System.out.println("Check!");
    }
    Thread.sleep(2000);
    driver.quit();
}
}
