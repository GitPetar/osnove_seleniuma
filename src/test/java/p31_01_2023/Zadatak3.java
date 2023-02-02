package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//Napisati program koji
//Kreirati folder downloads folder u projektu
//Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
//Cita href atribut sa glavne slike sa stranice
//Koristi link iz href atributa za skidanje slike
//Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
//Koristan link za skidanje fajlova u javi
//Azurirajte gitignore da ignorise downloads folder
public class Zadatak3 {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
    try {
        String url = driver.findElement(By.xpath("//img[@role]")).getAttribute("src");
        downloadUsingStream(url, "downloads/flying-ninja.jpg");
    } catch (IOException e) {
        e.printStackTrace();
    }
    driver.quit();
}

private static void downloadUsingStream(String urlStr, String file) throws IOException {
    URL url = new URL(urlStr);
    BufferedInputStream bis = new BufferedInputStream(url.openStream());
    FileOutputStream fis = new FileOutputStream(file);
    byte[] buffer = new byte[1024];
    int count = 0;
    while ((count = bis.read(buffer, 0, 1024)) != -1) {
        fis.write(buffer, 0, count);
    }
    fis.close();
    bis.close();
}
}

