package pages;

import Hooks.BaseHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    //BaseHooks hooks=new BaseHooks();




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


    public void do_click(By locator){

        wait_for_element_to_display(locator).click();

    }
    // to get single text
    public String getText_from_element(By locator){

        return wait_for_element_to_display(locator).getText();

    }

    // to Get Element from list

    public List<String> get_Element_from_List(By locator){

        List<String> list =new ArrayList<String>();
        try {
            List<WebElement> elements = wait_for_element_to_display(locator).findElements(locator);
            for (WebElement name : elements) {
                list.add(name.getText());
                return list;

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public void Javascript_scroll(WebElement element) throws  Exception{
        try {
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




}
