import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author PHY
 * @date 2020-06-26$-21:58
 */
public class TestUrl {
    @Test
    public void testURL() throws IOException {
        URL url=new URL("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%88%80%E5%89%91%E7%A5%9E%E5%9F%9F%E7%AC%AC4%E5%AD%A3%E6%A8%B1%E8%8A%B1%E5%8A%A8%E6%BC%AB&step_word=&hs=0&pn=12&spn=0&di=3300&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1920811146%2C1574826833&os=943820978%2C1057474119&simid=0%2C0&adpicid=0&lpn=0&ln=344&fr=&fmq=1593179883610_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fwww.wzpm123.cn%2Fimg.php%3Fi0.hdslb.com%2Fbfs%2Farticle%2F45036ce7a3e468c455c93858965484fd26c53813.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bozr48dn_z%26e3BvgAzdH3F%3Ff%3D%25El%25bD%25l9%25En%25b9%25Am%25Em%25lE%25b8%25Ec%25Am%25AF%25Eb%25BE%25AB%25Ec%25A0%25Bn%25El%25bD%25Ac%25Ec%25bl%25A0%25Ec%25Ad%25lm%25El%25bD%25lE%25EE%25bb%25lC%25E0%25B0%25Ab%25El%25bD%25Ac%25Ec%25bl%25A0%25Ec%25Ad%25lm&gsm=c&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.connect();
        FileOutputStream outputStream=new FileOutputStream("beauty.html");
        InputStream inputStream = urlConnection.getInputStream();
        int len;
        byte[] bytes=new byte[1024];
        while ((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        System.out.println("ok");


        outputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
