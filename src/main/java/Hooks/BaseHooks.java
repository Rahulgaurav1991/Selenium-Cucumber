package Hooks;

import Util.Config_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseHooks {

    public static WebDriver driver=null;



    @Before
    public void open_Browser() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Config_Reader.getURL());
    }

        @After(order = 1)
        public void takescreenshot(Scenario sc){
            if( sc.isFailed()){
                TakesScreenshot ts=(TakesScreenshot)driver;
                byte[] Sricfile = ts.getScreenshotAs(OutputType.BYTES);
                sc.attach(Sricfile, "image/png", " Screenshot"+ "/" +sc.getName());
            }

        }


    @After(order=0)
    public void tear_Down(){

        driver.close();
    }


    public static WebDriver get_Driver(){

        return  driver;
    }
}
