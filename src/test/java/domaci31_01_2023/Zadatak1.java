package domaci31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//1.Zadatak
//Napisati program koji:
//Podesava:
//implicitno cekanje za trazenje elemenata od 10s
//implicitno cekanje za ucitavanje stranice od 10s
//eksplicitno cekanje podeseno na 10s
//Podaci:
//Potrebno je u projektu ukljuciti 4 slike:
//front.jpg
//left.jpg
//right.jpg
//back.jpg
//Koraci:
//Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//Maksimizuje prozor
//Klik na edit ikonicu
//Klik na delete iz iskacuceg dijaloga
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte front.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 1.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte right.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 2.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Sacekajte da Next dugme bude klikljivo
//Klik na Next dugme
//Unesite tekst
//Klik na Next
//Klik na Preview
//Klik na Add to cart
//Sacekajte 5s
//Quit
public class Zadatak1 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
    driver.findElement(By.className("edit-image")).click();
    driver.findElement(By.xpath("//*[contains(text(),'Delete')]")).click();
    String[] files = {"test_data/front.jpg", "test_data/right.jpg", "test_data/left.jpg", "test_data" + "/back.jpg"};
    for (int i = 0; i < files.length; i++) {
        driver.findElement(By.id("cube-" + i + "-image")).click();
        driver.findElement(By.className("edit-image")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'Upload')"
        + "]"))));
        driver.findElement(By.id("imageUpload")).sendKeys(new File(files[i]).getAbsolutePath());
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[@loading]"), i));
        driver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'Done')]"))));
        driver.findElement(By.xpath("//*[contains(text(),'Done')]")).click();}
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("textareaID")).sendKeys("Tekst!");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Preview')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
        
    Thread.sleep(5000);
    driver.quit();
    }
    
}

