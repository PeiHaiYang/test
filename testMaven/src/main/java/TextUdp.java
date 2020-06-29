import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author PHY
 * @date 2020-06-26$-17:46
 * java基础教程UDP
 */



public class TextUdp {

    @Test
    public void testUdp() throws IOException {

        DatagramSocket socket = new DatagramSocket();
        String str = "使用UDP进行数据导弹发送";
        byte[] bytes=str.getBytes();
        InetAddress loopbackAddress = InetAddress.getLocalHost();
        DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length,loopbackAddress,9898 );
        socket.send(packet);
        socket.close();

    }
    @Test
    public void testrevice() throws IOException {
        DatagramSocket socket=new DatagramSocket(9898);
        byte[] bytes=new byte[200];
        DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }

}
