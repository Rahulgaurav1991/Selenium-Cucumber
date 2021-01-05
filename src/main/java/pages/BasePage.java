package pages;

import Hooks.BaseHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BasePage {

    //BaseHooks hooks=new BaseHooks();

    public static WebElement webAction(final By locator) {


        Wait<WebDriver> wait = new FluentWait<WebDriver>(BaseHooks.get_Driver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(Throwable.class)
                .withMessage(
                        "Webdriver waited for 50 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }


    public String wait_for_title_display(String title) throws  Exception{
        new WebDriverWait(BaseHooks.get_Driver(), 120).until(ExpectedConditions.titleIs(title));
        return title;
    }


    public WebElement wait_for_element_to_display(By locator){
        try {
            return new WebDriverWait(BaseHooks.get_Driver(), 120).until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public void do_click(By locator) throws Exception{

        wait_for_element_to_display(locator).click();

    }
    // to get single text
    public String getText_from_element(By locator) throws  Exception{

        return wait_for_element_to_display(locator).getText();

    }

    // to Get Element from list

    public List<String> get_Element_from_List(By locator){

        List<String> list =new ArrayList<String>();
        try {
            List<WebElement> elements = wait_for_element_to_display(locator).findElements(locator);
            for (WebElement name : elements) {
                list.add(name.getText());
            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public String get_Text_from_multiple_elements(By locator){
        String text=null;
        try {

            List<WebElement> elements = wait_for_element_to_display(locator).findElements(locator);
            for (WebElement name : elements) {
                text = name.getText();
            }
            return text;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;



    }

    public void Javascript_scroll(By locator, WebElement element) throws  Exception{
        try {
            wait_for_element_to_display(locator);
            JavascriptExecutor js = (JavascriptExecutor) BaseHooks.get_Driver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void move_to_element(WebElement element){
        try {
            new Actions(BaseHooks.get_Driver()).moveToElement(element).perform();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public List<Integer>get_text_from_number(By locator){
        try {
            List<Integer> list = new ArrayList<>();
            List<String> value = get_Element_from_List(locator);
            for (String name : value) {
                list.add(Integer.parseInt(name.replaceAll("[^0-9]", "")));

            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public boolean verify_display(WebElement element) throws Exception{
        return element.isDisplayed();

    }

    public  void enter_values(By locator,String value){
    	try {
    		wait_for_element_to_display(locator).sendKeys(value);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public void select_By_index(By locator, int index) {
    	try {
    	wait_for_element_to_display(locator);
    	new Select(BaseHooks.get_Driver().findElement(locator)).selectByIndex(index);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }




}
