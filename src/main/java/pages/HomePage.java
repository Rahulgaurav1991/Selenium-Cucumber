package pages;

import Hooks.BaseHooks;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage  extends BasePage{

	private By current_temp = By.xpath("//span[@class='summary swap']");
	private By expected_temp= By.xpath("//span[@class='first']//span");
	private By expectedTime=By.xpath("//span[@class='hour']/span");
	private By min_temp= By.xpath("//span[@class='minTemp']");
	private By max_temp= By.xpath("//span[@class='maxTemp']");
	private By page_scroll =By.xpath("//canvas[@class='ol-unselectable']");
	private By bar=By.xpath("//a[@data-day='0']//span[@class='toggle']");
	private By bar_temp1= By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
	private By bar_temp2 =By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");


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



    public boolean verify_time_difference() throws  Exception{
        List<Integer> timeDiffList= new ArrayList<>();
        List<Integer> time = get_text_from_number(expectedTime);
        for(int i=0;i<time.size();i++){
            int time1=time.get(i);
            int time2=time.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2 - time1;
            if(time1>time2)
                timeDiff = (time2 +12)- time1;

            timeDiffList.add(timeDiff);
            int occurance = Collections.frequency(timeDiffList, 2);
            boolean result = (occurance == timeDiffList.size());
            return result;
        }
        return false;
    }
    
    public List<String> getTimelineTempList() throws Exception{

        List<String> list =new ArrayList<>();

        String minTemp = getText_from_element(min_temp).split("˚")[0];
        String maxTemp = getText_from_element(max_temp).split("˚")[0];
        list.add(minTemp);
        list.add(maxTemp);
        return list;
        
        
    }

    public void scroll_webpage() throws Exception {

        //wait_for_element_to_display(page_scroll);
        //Thread.sleep(5000);
        Javascript_scroll(page_scroll,BaseHooks.get_Driver().findElement(By.xpath("(//div[@class='summary'])[1]")));
    }

    public List<String> getBar_timeLine() throws Exception {
        //Perform_click();
        List<String>list= new ArrayList<>();
        String bar_temp = getText_from_element(bar_temp1).split("˚")[0];
        String bar_temp_second = getText_from_element(bar_temp2).split("˚")[0];
        return list;
    }

    public void Perform_click(){
        try {
            do_click(bar);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
