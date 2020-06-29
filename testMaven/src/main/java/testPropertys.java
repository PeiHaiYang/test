import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PHY
 * @date 2020-06-29$-13:46
 */
public class testPropertys {
    @Test
    public void test02(){
        {
            InputStream resourceAsStream=null;
            try {
                Properties pro = new Properties();
                ClassLoader loader = testPropertys.class.getClassLoader();

                resourceAsStream = loader.getResourceAsStream("jdbc.properties");
               // System.out.println(resourceAsStream);
                pro.load(resourceAsStream);
                String username = pro.getProperty ("username");
                String password = pro.getProperty ("password");
                System.out.println(username);
                System.out.println(password);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }



    }
}
