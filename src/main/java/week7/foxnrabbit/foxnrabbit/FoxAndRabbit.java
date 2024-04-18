package week7.foxnrabbit.foxnrabbit;

import week7.foxnrabbit.Animal.Animal;
import week7.foxnrabbit.Animal.Fox;
import week7.foxnrabbit.Animal.Rabbit;
import week7.foxnrabbit.cell.Cell;
import week7.foxnrabbit.field.Field;
import week7.foxnrabbit.field.Location;
import week7.foxnrabbit.field.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*习题描述：
狐狸、兔子都有年龄；
到达一定年龄上限会自然死亡；
狐狸随机吃掉周围一只兔子；
狐狸、兔子可以随机生一只小的放在旁边格子；
如果不吃不生，狐狸、兔子可以随机向旁边格子移一步会随机吃掉*/

/*FoxAndRabbit程序执行入口：
主要思想：两层for循环，挨个cell执行移动、进食、生育；每次循环结束后repaint view；*/

//内部类版：
public class FoxAndRabbit{
    private Field thefield;
    private View theview;
    private JFrame frame;
    //内部类:定义在一个类内部的类，他可以自由访问外部类的成员
    private class StepListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("按下了");
            step();
            frame.repaint();
        }
    }
    public FoxAndRabbit( int size ){
        thefield = new Field(size, size);
        for( int row = 0; row <thefield.getHeight(); row++ ){
            for( int col = 0; col < thefield.getWidth(); col++ ){
                double probability = Math.random();
                if( probability <0.05 ){
                    thefield.place( row, col, new Fox());
                }else if( probability < 0.15 ){
                    thefield.place( row, col, new Rabbit());
                }
            }
        }
        theview = new View(thefield);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("FoxAndRabbit");
        frame.add(theview);
        JButton btnStep = new JButton("Step");
        frame.add(btnStep, BorderLayout.NORTH);//frame默认的布局管理器是BorderLayout，需要指定是哪一块区域（默认CENTER）
        //1.使用匿名内部类,定义在函数内部的类
        btnStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按下了");
                step();
                frame.repaint();

            }
        });
        //2.使用内部类，定义在类的内部的类
//        btnStep.addActionListener(new StepListener());

        frame.pack();
        frame.setVisible(true);
    }

    public void step(){
        for( int row = 0; row < thefield.getHeight(); row++ ){
            for( int col = 0; col < thefield.getWidth(); col++ ){
                Cell cell = thefield.get(row, col);
                if( cell != null ){
                    Animal animal = (Animal)cell;
                    animal.grow();
                    if( animal.isAlive()){
                        //move
                        Location loc = animal.move(thefield.getFreeNeighbour(row, col));
                        if( loc != null ){
                            thefield.move(row, col, loc);
                        }
                        //eat   animal.eat(thefield);
                        if( animal instanceof Fox){
                            Cell[] neighbour = thefield.getNeighbour(row, col);
                            ArrayList<Animal> listRabbit = new ArrayList<Animal>();
                            //得到当前邻居周围所有的兔子listRabbit
                            for( Cell an : neighbour ){
                                if( an instanceof Rabbit){
                                    listRabbit.add( (Rabbit)an );
                                }
                            }
                            if( !listRabbit.isEmpty() ){
                                Animal fed = animal.feed(listRabbit);//只有fox的feed函数有效，返回被吃的对象
                                if( fed != null ){
                                    thefield.remove((Cell)fed);
                                }
                            }
                        }
                        //breed
                        Animal baby = animal.breed();
                        if( baby != null ){
                            thefield.placeRandomAdj(row, col, (Cell)baby);
                        }
                    }else{
                        thefield.remove(row, col);
                    }
                }
            }
        }
    }

    public void start( int steps ){
        for( int i = 0; i < steps; i++){
            step();
            theview.repaint();
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(30);
//        fnr.start(100);
    }
}