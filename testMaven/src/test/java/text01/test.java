package text01;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author PHY
 * @date 2020-06-24$-18:52
 */
public class test {
    @Test
    public void textGetName(){
        System.out.println("hello world");
    }

    @Test
    public void client() {
        Socket socket= null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,9999);
            outputStream = socket.getOutputStream();
            outputStream.write("你好我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public  void server(){
        ServerSocket socket= null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream btos= null;
        try {
            socket = new ServerSocket(9999);
            accept = socket.accept();
            inputStream = accept.getInputStream();
            btos = new ByteArrayOutputStream();
            int len;
            byte[] bytes=new byte[20];
            while ((len=inputStream.read(bytes))!=-1)
            {
                btos.write(bytes,0,len);
            }
            System.out.println(btos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (btos != null) {
                    btos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (accept != null) {
                    accept.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }
}


