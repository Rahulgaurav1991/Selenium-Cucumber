package stepDefinitions;

import constantValues.ConstantUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GuruHomePage;


public class GuruTelecom_SD {

    private String Expected_String=null;

    public GuruHomePage guruHomePage=new GuruHomePage();


    @Given("User is at {string} home page")
    public void user_is_at_home_page(String title) throws Exception {

        Assert.assertEquals(guruHomePage.verify_title(ConstantUtils.GURU_TITLE), title);

    }

    @When("Add Tariff Plan to Customer should display at home Page")
    public void add_tariff_plan_to_customer_should_display_at_home_page() throws Throwable {

        Assert.assertTrue(guruHomePage.verify_Tariff_Plan_to_Customer());

    }

    @Then("User clicks on Add Tariff Plan to Customer")
    public void user_clicks_on_add_tariff_plan_to_customer() throws Throwable {

        guruHomePage.click_Tariff_Plan_to_Customer();


    }

    @Then("user navigate to {string}")
    public void user_navigate_to_something(String next_page_title) throws Throwable {

        Assert.assertEquals(guruHomePage.verify_title(ConstantUtils.TARIFF_TITle), next_page_title);

    }

    @And("User enter Customer id as {string} and click on submit button")
    public void user_enter_customer_id_as_something_and_click_on_submit_button(String Tariff_ID) throws Throwable {

        System.out.println("Tariff-ID is-->"+Tariff_ID);
        guruHomePage.enter_Tariff(Tariff_ID);


    }


    @Then("it should navigate to traffic selection page")
    public void it_should_navigate_to_traffic_selection_page() throws Throwable {

        Expected_String=guruHomePage.verify_Tariff_Page();
        Assert.assertEquals("Both are not matching",Expected_String,ConstantUtils.ACTUAL_HEADER);

    }

    @And("user able to verify {string} at Monthly Rental column and able to select Select Tariff Plans checkbox and click_on add traffic_plan to customer")
    public void user_able_to_verify_something_at_monthly_rental_column_and_able_to_select_select_tariff_plans_checkbox_and_clickon_add_trafficplan_to_customer(String amount) throws Throwable {

        Expected_String=guruHomePage.verify_Monthly_Rental();
        Assert.assertEquals("Both are not same",Expected_String,amount);
        guruHomePage.select_tariff_button_click_add();

    }

    @Then("Verify the {string} is displayed")
    public void verify_the_something_is_displayed(String title) throws Throwable {

        Expected_String= guruHomePage.verify_Success_Message();
        Assert.assertEquals("Both are not equals",Expected_String,title);

    }


}
