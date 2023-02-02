package domaci31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//3. Zadatak
//Napisati program koji:
//Ucitava stranicu https://itbootcamp.rs/
//Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//Cita sve linkove slika iz slajdera
//Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u
// folder itbootcamp_slider u okviru projekta
//Azurirajte gitignore da ignorise itbootcamp_slider folder
public class Zadatak3 {
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://itbootcamp.rs/");
    Actions actions = new Actions(driver);
    actions.scrollToElement(driver.findElement(By.xpath("(//*[@class='owl-stage-outer'])[last()]"))).perform();
    ArrayList<String> linkovi = new ArrayList<>();
    List<WebElement> items = driver.findElements(By.xpath("(//*[@class='owl-stage-outer'])[2]//*[@src]"));
    System.out.println(items.size());
    for (WebElement item : items) {
        if (!linkovi.contains(item.getAttribute("src"))) {
            linkovi.add(item.getAttribute("src"));
        }
    }
    System.out.println(linkovi);
    URL url;
    HttpURLConnection http;
    int counter = 0;
    for (String link : linkovi) {
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            http = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (200 <= http.getResponseCode() && http.getResponseCode() < 300) {
                BufferedImage saveImage = ImageIO.read(url);
                ImageIO.write(saveImage, "png", new File("itbootcamp_slider/" + counter++ + ".png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    Thread.sleep(5000);
    driver.quit();
}
}
