package stepDefinitions;

import constantValues.ConstantUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

import java.util.List;

public class DarkSky_SD {

    HomePage homePage = new HomePage();

    @Given("I am on Darksky Home Page {string}")
    public void i_am_on_darksky_home_page(String title) throws Throwable {

        Assert.assertEquals(homePage.verify_title(ConstantUtils.TITLE), title);

    }

    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() throws Throwable {

        Assert.assertEquals(homePage.get_current_temp(), homePage.get_updated_temp());

    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {

        Assert.assertTrue("All times are not in difference Two",homePage.verify_time_difference());

    }
    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {
        Assert.assertEquals(homePage.getTimelineTempList(),homePage.getBar_timeLine());


    }
}
