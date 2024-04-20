package week8;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
//流的应用之建立socket对象
//终端 nc -l 12345建立服务，监听12345端口

public class IOTest6 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getByName("localhost"), 12345);
            //通过socket.getOutputStream()得到虚拟的流，这个流并不是在任何文件上，表达的是该程序和服务端程序间的网络连接
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("Hello World");
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//gb18030.txt测试文本
            System.out.println(in.readLine());
            out.close();
            socket.close();
            //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
