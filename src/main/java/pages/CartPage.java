package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
public CartPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getDeleteButton(int row) {return driver.findElement(By.xpath("(//*[@class='remove'])[" + row + "]"));}

//hvata delete dugme za red po indeksu
//input za kupon
//dugme apply coupon
//update cart dugme
//hvata sve redove tabele

public List<WebElement> getTableRows() {
    return new ArrayList<WebElement>(driver.findElements(By.xpath("//*[contains(@class," +
    "'woocommerce-cart-form__cart-item cart_item')]")));
}
//public WebElement getTableRow() {
//    return driver.findElement(By.xpath("//*[contains(@class," +
//    "'woocommerce-cart-form__cart-item cart_item')]"));
//}
}
