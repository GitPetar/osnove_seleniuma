package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”
public class Zadatak5 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.ebay.com/");
    
    Select select = new Select(driver.findElement(By.name("_sacat")));
    select.selectByVisibleText("Crafts");
    
    Thread.sleep(3000);
    driver.quit();
}
}
