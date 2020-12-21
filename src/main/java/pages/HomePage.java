package pages;

import org.openqa.selenium.By;

public class HomePage  extends BasePage{

    By current_temp = By.xpath("//span[@class='summary swap']");

    By expected_temp= By.xpath("//span[@class='first']//span");



    public String verify_title(String title) throws Exception {
        try{
            return wait_for_title_display(title);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String get_current_temp()
    {
        try {
            String s = getText_from_element(current_temp).split("˚")[0];
            return s;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return  null;


    }

    public String get_updated_temp(){
        try {
            return getText_from_element(expected_temp).split("°")[0];
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
