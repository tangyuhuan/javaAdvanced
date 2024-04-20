package week8;

import javax.xml.crypto.Data;
import java.io.*;

//过滤器流：在已有流的基础上添加一层层的过滤器，可以将复杂数据类型写入文件中
// FileOutputStream只能用来写字节，通过过滤器流DataOutputStream，可以将int、float、double等基本类型写入文件中,而不仅仅是单个字节
//过滤器流以二进制的形式将数据写入文件，保留了数据的原始格式（a.dat中记录的是二进制的0001E240，可以用0xED打开查看）
public class IOTest3 {
    public static void main(String[] args) {
        System.out.println("hi");
        try {
            //过滤器流DataOutputStream 起到读写基本数据类型的作用
            //过滤器流BufferedOutputStream 起到缓冲的作用
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("a.dat")));
//            int i = 0xcafebabe;//16进制整数0xcafebabe
            int i = 123456;
            out.writeInt(i);
            out.close();
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("a.dat")));
            int j = in.readInt();
            System.out.println(j);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
