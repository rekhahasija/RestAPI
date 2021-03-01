package encora.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            try {
                FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                        + "/src/main/java/encora/config/config.properties");
                prop.load(ip);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
