package week6.foxnrabbit.Animal;

import week6.foxnrabbit.cell.Cell;

import java.awt.*;
import java.util.ArrayList;
/*Fox类：继承animal，cell
构造方法：生存时间20，生育年龄4；
重写抽象方法：animal的 生育、进食；
生育：5%概率生育，返回 Animal；
进食：返回cell(传入附近兔子数组)，被吃掉概率0.2，可通过cell是否为null判断给否被吃掉；
重写接口cell方法：draw，传入cell 图，坐标，大小；*/

public class Fox extends Animal implements Cell{
    public Fox(){
        super(20,4);     //最大年龄，生育年龄
    }

    @Override
    public void draw( Graphics g, int x, int y, int size ){
        int alpha = (int)((1-getAgePercent())*255);
        g.setColor(new Color(0,0,0,alpha));
        g.fillRect(x, y, size, size);
    }

//    @Override
//    public Animal breed() {
//        Animal ret = null;
//        if( isBreedable() && Math.random() < 0.05 ){   //5%的几率breed
//            ret = new Fox();
//        }
//        return ret;
//    }
//为Fox类提供具体的实现：
    @Override
    protected double getBreedProbability() {
        return 0.05;
    }

    @Override
    protected Animal breedAnimal() {
        return new Fox();
    }

    @Override
    public String toString(){
        return "Fox:"+super.toString();
    }

    @Override
    public Animal feed(ArrayList<Animal> neighbour){    //返回被吃的兔子
        Animal ret = null;
        if( Math.random() < 0.2 ){
            ret = neighbour.get((int)(Math.random()*neighbour.size()));
            longerlife(2);
        }
        return ret;
    }
}
