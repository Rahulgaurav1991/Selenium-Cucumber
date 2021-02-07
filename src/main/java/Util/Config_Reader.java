package Util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {


    public static Properties getProperties() throws  Exception{

        FileInputStream fis= new FileInputStream("src/main/java/Util/config.properties");
        Properties  prop =new Properties();
        prop.load(fis);
        return prop;

    }


    public static String getURL() throws  Exception {
        return getProperties().getProperty("Dark_sky_URL");

    }
}
