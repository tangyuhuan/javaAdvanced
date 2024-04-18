package week7.foxnrabbit.cell;

import java.awt.*;
//cell接口的作用：所有实现了cell类的对象可以被放到field里面去
public interface Cell {
    void draw(Graphics g, int x, int y,int size);
}
