package week8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//文件流：对文件读写操作
// FileOutputStream、FileInputStream
// 本类中构造了一个字节数组并将其写入文件
public class IOTest2 {
    public static void main(String[] args) {
        System.out.println("hi");
        byte[] buf = new byte[10];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) i;
        }
        try {
            FileOutputStream fos = new FileOutputStream("a.dat");
            //DAT文件类型主要是“数据”文件。可以是任何内容，比如：文字，图形，视频或一般的二进制数据
            //终端查看
            // hexdump a.dat
            fos.write(buf);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
