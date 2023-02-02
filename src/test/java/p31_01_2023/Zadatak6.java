package p31_01_2023;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//Zadatak (Za vezbanje)
//Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots po imenom
// screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//Koristan link https://www.javatpoint.com/java-date-to-string

//Napisati program koji:
//Kreirati screenshots folder u projektu
//Ucitava stranicu https://cms.demo.katalon.com/
//Kreira screenshot stranice
//Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//Koristan link
public class Zadatak6 {
public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://cms.demo.katalon.com/");
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_hhmmss");
    String datum = dateFormat.format(date);
    TakesScreenshot scrShot = ((TakesScreenshot) driver);
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/screenshot" + datum + ".jpg");
    Files.copy(SrcFile, screenshot);
    driver.quit();
}
}


