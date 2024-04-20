package week8;

import java.io.*;
//文本流
//Reader和Writer处理 文本的输入输出
//PrintWriter是抽象类Writer的子类
//BufferedReader是抽象类Reader的子类

public class IOTest4 {
    public static void main(String[] args) {
        System.out.println("hi");
        try {
            //FileOutputStream只能处理字节，OutputStreamWriter是Stream与Writer之间的桥梁
            //这样写下来的文件是一个ASCII码/国标码的文件，取决于本机的系统，会自动从Unicode换算成ASCII码/国标码
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt"))));
            int i = 123456;
            out.println(i);
            out.close();
//          以下两种写法等价
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/week8/IOTest3.java")));
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/week8/IOTest3.java"));

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
