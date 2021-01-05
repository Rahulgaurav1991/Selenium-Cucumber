package pages;

import Hooks.BaseHooks;
import org.openqa.selenium.By;

public class GuruHomePage extends BasePage {


    private By traffic=By.xpath("//section[@id='one']//a[.='Add Tariff Plan to Customer']");
    private By traffic_text= By.id("customer_id");

    private By submit_button =By.name("submit");

    private By header= By.xpath("//header[@class='align-center']//h1");

    private By table_value= By.xpath("//thead//th[2]/../../..//td[2]");

    private By select_button =By.xpath("//label[@for='sele']/..");

    private By add_button =By.name("submit");

    private By scroll = By.xpath("//h2[.='Unapproved Tariff Plans']");


    private By success_message= By.xpath("//section[@id='main']//h2");


    public String verify_title(String title) throws Exception {
        try{
            return wait_for_title_display(title);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean verify_Tariff_Plan_to_Customer() throws Exception {

        Javascript_scroll(traffic, BaseHooks.get_Driver().findElement(By.xpath("//section[@id='one']//a[.='Add Tariff Plan to Customer']")));
        verify_display(BaseHooks.get_Driver().findElement(By.xpath("//section[@id='one']//a[.='Add Tariff Plan to Customer']")));
        return true;
    }

    public void click_Tariff_Plan_to_Customer() throws Exception {
        do_click(traffic);
    }

    public void enter_Tariff(String text) throws Exception {
        enter_values(traffic_text,text);
        do_click(submit_button);

    }

    public String verify_Tariff_Page() throws Exception{
        return getText_from_element(header);


    }


    public String verify_Monthly_Rental() throws Exception {
        return getText_from_element(table_value);

    }

    public void select_tariff_button_click_add() throws Exception {
        Javascript_scroll(scroll,BaseHooks.get_Driver().findElement(By.xpath("//h2[.='Unapproved Tariff Plans']")));
        do_click(select_button);
        do_click(add_button);

    }

    public String verify_Success_Message() throws Exception {

        return getText_from_element(success_message);

    }
}
