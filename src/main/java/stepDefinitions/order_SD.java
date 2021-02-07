package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.orderPage;

import java.util.Collections;

public class order_SD {

    orderPage page=new orderPage();



    @Given("user is at Product page and clicks on Product and selects colors an quantity")
    public void user_is_at_product_page_and_clicks_on_product_and_selects_colors_an_quantity() throws Throwable {
    page.add_Items_at_cart();
    }

    @When("user add to cart")
    public void user_add_to_cart() throws Throwable {
        page.click_cartbutton();

    }

    @Then("user can see same product name with same price with Quantity and Total Price should be same as per Qunatity")
    public void user_can_see_same_product_name_with_same_price_with_quantity() throws Throwable {
        String product_Orderpage=page.get_productname_form_orderpage();
        String prodcut_price =page.getPriceformOrderPage();
        page.click_cart_icon();
        String value= page.get_Product_from_cart();
        String value2=page.get_price_from_cart();
        //System.out.println(product_Orderpage+" "+prodcut_price+" "+value+" "+value2);
        Assert.assertEquals("Both are not same", product_Orderpage,value);
        Assert.assertEquals("both are not same" ,prodcut_price,value2);
//        System.out.println(page.totalPrice_from_cart());
//        System.out.println(page.getQantity());
//        System.out.println(page.get_price_from_cart_value() * page.getQantity());
//        int qunatity=page.getQantity();
          Assert.assertTrue(page.totalPrice_from_cart()==page.get_price_from_cart_value() * page.getQantity());





    }

    @And("clicks on checkout button")
    public void clicks_on_checkout_button() throws Throwable {
        page.click_checkout_button();


    }

    @Then("checkout page must be displayed  and user complete the Address details ar per zip code")
    public void checkout_page_must_be_displayed_and_user_complete_the_address_details_ar_per_zip_code() throws Throwable {
    Assert.assertEquals(page.verify_title(),"CHECKOUT");
    page.fill_Details();
    Assert.assertTrue(page.verify_valid_zipcode());
    }


}
