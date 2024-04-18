package week7.kcb;

import javax.swing.*;

public class KCB {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KCB");
        JTable table = new JTable(new KCBData());
        JScrollPane pane = new JScrollPane(table);//JScrollPane实现表格的滚动操作
        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//能够关闭
        frame.setVisible(true);
    }
}
