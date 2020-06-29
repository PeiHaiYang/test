import java.net.InetAddress;

/**
 * @author PHY
 * @date 2020-06-17$-17:37
 */
public class TextIntAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress=InetAddress.getByName("www.loverblue.cn");
            String inetAddress2= inetAddress.getHostName();
            InetAddress inetAddress1=InetAddress.getLocalHost();
            System.out.println(inetAddress1);
            System.out.println(inetAddress2);
            System.out.println(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
