package week8;

import java.io.IOException;
import java.util.Scanner;
//流
public class IOTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] buffer = new byte[1024];
        //所有IO操作都存在风险 需要异常处理
        try {
            int len = System.in.read(buffer);//按b进行读取
            String s = new String(buffer, 0, len);
            System.out.println("读到了"+len+"字节");//一个汉字对应多个字节，这和编码有关，UTF8一个汉字占3个字节，GBK一个汉字占2个字节。
            System.out.println(s);
            System.out.println("s的长度是"+s.length());//一个汉字对应一个字符
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
