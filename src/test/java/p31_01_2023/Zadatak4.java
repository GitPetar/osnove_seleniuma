package p31_01_2023;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//Napisati program koji:
//Kreirati screenshots folder u projektu
//Ucitava stranicu https://cms.demo.katalon.com/
//Kreira screenshot stranice
//Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//Koristan link
public class Zadatak4 {
public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://cms.demo.katalon.com/");
    TakesScreenshot scrShot = ((TakesScreenshot) driver);
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/screenshot1.jpg");
    Files.copy(SrcFile, screenshot);
    driver.quit();
}
}


