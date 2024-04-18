package week7.foxnrabbit.Animal;
import week7.foxnrabbit.cell.Cell;

import java.awt.*;
/*Rabbit类：继承animal，cell
构造方法：生存时间10，生育年龄2；
重写抽象方法：animal的 生育、进食；
生育：12%概率生育，返回 Animal；
重写接口cell方法：draw，传入cell 图，坐标，大小；*/
public class Rabbit extends Animal implements Cell {

    public Rabbit() {
        super(10, 2);
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        int alpha = (int)((1-getAgePercent())*255);
        g.setColor(new Color(255,0,0,alpha));
        g.fillRect(x, y, size, size);
    }

    @Override
    public Animal breed() {
        Animal ret = null;
        if( isBreedable() && Math.random() < 0.12 ){   //12%的几率breed
            ret = new Rabbit();
        }
        return ret;
    }

    @Override
    public String toString(){
        return "Rabbit:"+super.toString();
    }
}