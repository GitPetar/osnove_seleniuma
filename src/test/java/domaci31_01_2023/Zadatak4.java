package domaci31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//4.Zadatak (za vezbanje)
//Napisati program koji:
//Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//Ceka da se prikazu 4 item-a a upload
//Klik na upload
//Ceka da se upload zavrsi
public class Zadatak4 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://blueimp.github.io/jQuery-File-Upload/");
    String[] files = {"test_data/front.jpg", "test_data/right.jpg", "test_data/left.jpg", "test_data" + "/back.jpg"};
    Arrays.stream(files).forEach(file -> driver.findElement(By.xpath("//input[@type='file']")).sendKeys(new File(file).getAbsolutePath()));
    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), 4));
    for (WebElement element : driver.findElements(By.xpath("//tbody/tr"))) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr[contains(@class,'template-download')]"),
    4));
    
//    try {
//        Thread.sleep(5000);
//    } catch (InterruptedException e) {
//       throw new RuntimeException(e);
//   }
    driver.quit();
}
}
