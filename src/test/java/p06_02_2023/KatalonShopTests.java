package p06_02_2023;

import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

//Zadatak
//Kreirati NavPage koja ima:
//cart link
//checkout link
//my account link
//sample page link
//shop link
//Kreirati ProductPage koja ima:
//quantity
//add to cart button
//poruka o dodavanju proizvoda u korpu
//	Kreirati CartPage
//hvata delete dugme za red po indeksu
//input za kupon
//dugme apply coupon
//update cart dugme
//hvata sve redove tabele
//
//
//	Kreirati KatalonShopTests klasu:
//	baseUrl: https://cms.demo.katalon.com
//	Test #1:  Adding product with quantity to the cart
//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//
//	Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0
public class KatalonShopTests extends BaseTest {
@Test(priority = 10)
@Description("Test #1:  Adding product with quantity to the cart")
void Test1() {
    driver.get(baseUrl + "/product/flying-ninja");
    productPage.getQuantity().clear();
    productPage.getQuantity().sendKeys("3");
    productPage.getAddToCartButton().click();
    Assert.assertTrue(productPage.getAddToCartMessage().getText().contains("Flying Ninja"), "Add to cart message " +
    "does" + " " + "not contain \"Flying Ninja\"");
    navPage.getCartLink().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Current url does not contain \"cart\"");
    Assert.assertEquals(cartPage.getTableRows().size(),1,"Number of cart items does not match expected");
    
}

@Test(priority = 20)
@Description("Test #2:  Removing product from cart")
void Test2() throws InterruptedException {
    navPage.getCartLink().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Current url does not contain \"cart\"");
    Assert.assertEquals(cartPage.getTableRows().size(),1,"Number of cart items does not match expected");
    cartPage.getDeleteButton(1).click();
    Thread.sleep(2000);
    Assert.assertEquals(cartPage.getTableRows().size(),0,"Number of cart items does not match expected");
    
}
}


