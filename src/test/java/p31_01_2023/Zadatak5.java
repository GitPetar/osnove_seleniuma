package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Napisati program koji:
//Ucitava stranicu https://cms.demo.katalon.com/
//Hvata  sve href atribute svih linkova iz navigacije
//Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//Koristan link za citanje status koda nekog url-a
public class Zadatak5 {
public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://cms.demo.katalon.com/");
    List<WebElement> menu = driver.findElements(By.xpath("//div[@id='primary-menu']//a"));
    //List<String> href = new ArrayList<>();
    for (int i = 0; i < menu.size(); i++) {
        //href.add(menu.get(i).getAttribute("href"));
        URL url = new URL(menu.get(i).getAttribute("href"));
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        if (200 <= http.getResponseCode() && http.getResponseCode() < 400) {
            System.out.println("Status je izmedju 200 i 400");
        } else {System.out.println("Status nije izmedju 200 i 400");}
    }
}
}
