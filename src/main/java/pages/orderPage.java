package pages;

import org.openqa.selenium.By;

public class orderPage extends  BasePage{


    By product= By.xpath("//div[@class='size-button'][normalize-space()='S']");
    By quantity= By.id("demo-simple-select");
    By Product_name= By.xpath("(//div[@class='productname-container'])[1]//h1");
    By product_price= By.xpath("//span[@class='price-gap']");
    By cart_Button = By.xpath("//span[@class='cart-button']");
    By cart_icon= By.xpath("//img[@alt='cart.svg']");
    By Prducts_at_cart=By.xpath("//div[@class='cart-product-properties display-column  undefined']//h2");
    By ProductsPrice_at_cart=By.xpath("//div[@class='popup-cart-product-price uniqlo-font']");

    By Select_quantity= By.xpath("//li[@data-value='4']");
    By Checkout_button =By .xpath("//div[@class='checkout-option align-center uniqlo-font']");

    By CheckoutTittle= By.xpath("//div[@class='checkout-flow-text uniqlo-font']");

    By zipcode = By .id("PINCODE_Pincode");

    By disableZipcode =By.xpath("//div[contains(@class,'MuiInputBase-root MuiInput-root MuiInput-underline Mui-disabled Mui-disabled MuiInputBase-formControl MuiInput-formControl')]//input[@id='PINCODE_Pincode']");

    By tickMark=By.xpath("//img[@alt='verified']");

    By cartTotalPrice=By.xpath("//div[@class='justify-content-space-between total-amount-container uniqlo-font']//div[2]");

    By quanttity=By.xpath("//body/div[@role='presentation']/div[@class='MuiPaper-root MuiPopover-paper MuiPaper-elevation8 MuiPaper-rounded']/div[@class='cart-modal-Container selected-product-container align-center display-column']/div[@class='container-for-added-products']/div[1]/div[2]/div[1]/div[1]");


    public void add_Items_at_cart() throws Exception {

        do_click(product);
        do_click(quantity);
        do_click(Select_quantity);



    }

    public void click_cartbutton() throws Exception {
        do_click(cart_Button);
    }

    public String get_productname_form_orderpage() throws Exception {

        return getText_from_element(Product_name);


    }
    public String getPriceformOrderPage() throws Exception {
        return getText_from_element(product_price);
    }
    public void click_cart_icon() throws Exception {
        do_click(cart_icon);

    }

    public String get_Product_from_cart(){

        return get_Text_from_multiple_elements(Prducts_at_cart);
    }

    public String get_price_from_cart(){

        return  get_Text_from_multiple_elements(ProductsPrice_at_cart).replaceAll("₹","").trim();
    }
    public void click_checkout_button() throws Exception {
        Javascript_scroll(Checkout_button);
        do_click(Checkout_button);


    }
    public String verify_title() throws Exception {
        return getText_from_element(CheckoutTittle);

    }

    public void fill_Details() throws Exception {
        do_click(zipcode);
        //wait_for_element_to_display(zipcode);
        enter_values_with_Tab_out(zipcode,"560063");
    }

    public boolean verify_valid_zipcode() throws Exception {
        return verify_display(tickMark);


    }



    public double totalPrice_from_cart() throws Exception {

        return Double.parseDouble(getText_from_element(cartTotalPrice).replaceAll("[₹,]","").trim());



    }

    public int getQantity() throws Exception {

        return Integer.parseInt(getText_from_element(quanttity).replaceAll("[^0-9]","").trim());
    }

    public double get_price_from_cart_value(){

        return  Double.parseDouble(get_Text_from_multiple_elements(ProductsPrice_at_cart).replaceAll("[₹,]","").trim());
    }

}


