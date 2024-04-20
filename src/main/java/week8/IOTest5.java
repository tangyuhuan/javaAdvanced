package week8;

import java.io.*;
//汉字编码，指定编码解码的字符集


public class IOTest5 {
    public static void main(String[] args) {
        try {
            //FileInputStream对象处理二进制，InputStreamReader对象处理文本，把二进制数据转换成文本，如果不指定就以系统默认方式转换,以下是给定字符集GB18030
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("gb18030.txt"),"GB18030"));//gb18030.txt测试文本
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("gb18030.txt")));//gb18030.txt�����ı�，目前汉字的运行环境是utf8，不是国标，所以乱码
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt")));//utf-8测试文本
//            BufferedReader in = new BufferedReader(new FileReader("gb18030.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
