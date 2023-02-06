package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
public ProductPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}
public WebElement getQuantity(){return driver.findElement(By.xpath("//input[@type='number']"));}
public WebElement getAddToCartButton(){return driver.findElement(By.xpath("//button[@type='submit']"));}
public WebElement getAddToCartMessage(){return driver.findElement(By.className("woocommerce-message"));}


//quantity
//add to cart button
//poruka o dodavanju proizvoda u korpu
}
