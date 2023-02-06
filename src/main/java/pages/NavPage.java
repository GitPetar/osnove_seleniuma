package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
public NavPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getCartLink() {
    return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon" + ".com/cart/']"));
}

public WebElement getCheckoutLink() {return null;}

public WebElement getMyAccountLink() {return null;}

public WebElement getSamplePageLing() {return null;}

public WebElement getShopLink() {return null;}
}

