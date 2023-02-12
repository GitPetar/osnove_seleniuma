package domaci06_02_2023;
//Kreirati pageve:
//BuyBoxPage koja pribavlja:
//input za kolicinu
//select za velicinu
//add to cart dugme
//add to wishlist dugme
//metodu koja vraca element boje.
//Metoda kao parametar prima naziv boje
//(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//prema trazenoj vrednosti.
//metodu koja skrola do ovog dela stranice
//LayerCartPage koja pribavlja:
//continue shopping dugme
//proced to checkout dugme
//element koji vraca atrubute
// proizvoda (sa slike je to desno od devojke)
//element koji cuva quantity
//(takodje desno od devojke)
//element koji cuva total price
//metodu koja ceka da dijalog bude vidljiv
//metodu koja ceka da dijalog bude nevidljiv
//

import jdk.jfr.Description;
import org.testng.annotations.Test;

//TopMenuPage koja pribavlja:
//metodu koja vraca WOMEN link iz glavnom menija
//metodu koja vraca DRESSES link iz glavnom menija
//metodu koja vraca T-SHIRTS link iz glavnom menija
//metodu koja vraca podmeni za WOMEN
//metodu koja vraca podmeni za DRESSES
//
//	HeaderPage koja pribavlja:
//shop phone element - gde je prikazan broj telefona
//contact us link
//sign in link
//
//
//
//Kreirati klasu AutomationPracticeTests
//baseUrl: http://automationpractice.com/
//	Test #1:  Adding product to the cart
//Ucitati stranicu /index.php?id_product=1&controller=product
//Odskrolati do buy box-a
//Postavite kolicinu na 3
//Izaberite velicinu L
//Izaberite plavu boju
//Kliknite na dugme add to cart
//Cekajte da dijalog layer cart bude vidljiv
//Verifikovati da je kolicina iz layer cart dijalog 3
//Verifikovati da je velicina L
//Verifikovati da je izabran proizvod sa plavom bojom
//Verifikovati da je total price 3 puta veci od cene proizvoda
//Kliknite na dugme continue shopping
//cekajte da dijalog layer cart postane nevidljiv
//Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
//Kliknite na dugme add to cart
//Cekajte da dijalog bude vidljiv
//kliknite na dugme proceed to checkout
//Verifikujte da je naslov stranice Order - My Store
//
//
//	Test #2:  Top menu mouse over
//Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
//Verifikujte da je podmeni za women deo vidljiv
//Predjite misem preko dresses linka.
//Verifikujte da je podmeni za dresses deo vidljiv
//Predjite misem preko t-shirts linka.
//Verifikujte podmeniji za womens i dresses nevidljivi
//Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
//Provera preko za vidljivost preko soft assert-a
//
//	Test #3:  Phone number visibility check on resize
//Maksimizujte prozor
//Proverite da je element za broj telefona vidljiv
//Smanjite dimenziju pretrazivaca na velicinu 767 x 700
//Proverite element za broj telefona nije vidljiv
//Promenite dimenziju pretrazivaca na 768 x 700
//Proverite da je broj telefona vidljiv
//Maksimizujte prozor
//Provera preko soft asserta
//
//
//
//Test #4:  Header links check
//Kliknite na contact us link
//Verifikujte da je naslov stranice Contact us - My Store
//Kliknite na sign in link
//Verifikujte da je naslov stranice Login - My Store
//Provera preko soft asserta
public class AutomationPracticeTests extends BaseTest {
@Test
@Description("Test #1:  Adding product to the cart")
public void addingProductToTheCart() {
    driver.get(baseUrl + "/index.php?id_product=1&controller=product");
    ////Odskrolati do buy box-a
    ////Postavite kolicinu na 3
    ////Izaberite velicinu L
    ////Izaberite plavu boju
    ////Kliknite na dugme add to cart
    ////Cekajte da dijalog layer cart bude vidljiv
    ////Verifikovati da je kolicina iz layer cart dijalog 3
    ////Verifikovati da je velicina L
    ////Verifikovati da je izabran proizvod sa plavom bojom
    ////Verifikovati da je total price 3 puta veci od cene proizvoda
    ////Kliknite na dugme continue shopping
    ////cekajte da dijalog layer cart postane nevidljiv
    ////Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
    ////Kliknite na dugme add to cart
    ////Cekajte da dijalog bude vidljiv
    ////kliknite na dugme proceed to checkout
    ////Verifikujte da je naslov stranice Order - My Store
}

@Test
@Description("Test #2: Top menu mouse over")
public void topMenuMouseOver() {
    ////	Test #2:  Top menu mouse over
    ////Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
    ////Verifikujte da je podmeni za women deo vidljiv
    ////Predjite misem preko dresses linka.
    ////Verifikujte da je podmeni za dresses deo vidljiv
    ////Predjite misem preko t-shirts linka.
    ////Verifikujte podmeniji za womens i dresses nevidljivi
    ////Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
    ////Provera preko za vidljivost preko soft assert-a
}

@Test
@Description("Test #3:  Phone number visibility check on resize")
public void phoneNumberVisibilityCheckOnResize() {
    ////	Test #3:  Phone number visibility check on resize
    ////Maksimizujte prozor
    ////Proverite da je element za broj telefona vidljiv
    ////Smanjite dimenziju pretrazivaca na velicinu 767 x 700
    ////Proverite element za broj telefona nije vidljiv
    ////Promenite dimenziju pretrazivaca na 768 x 700
    ////Proverite da je broj telefona vidljiv
    ////Maksimizujte prozor
    ////Provera preko soft asserta
}

@Test
@Description("Test #4:  Header links check")
public void headerLinksCheck() {
    ////Kliknite na contact us link
    ////Verifikujte da je naslov stranice Contact us - My Store
    ////Kliknite na sign in link
    ////Verifikujte da je naslov stranice Login - My Store
    ////Provera preko soft asserta
}
}
