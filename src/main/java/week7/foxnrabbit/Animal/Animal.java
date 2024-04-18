package week7.foxnrabbit.Animal;

import week7.foxnrabbit.field.Location;

import java.util.ArrayList;
/*Animal抽象类
animal抽象类是fox，rabbit的父类：
属性：ageLimit(生存时间)，breedableAge(生育年龄)，age(现年龄)，isAlive；
方法：
        **构造方法：**生存时间、生育年龄；
        **简单方法：**获取年龄、年龄百分比、成长(到年龄死亡)、见耶稣、确定没死、确定能生、寿命增长的方法；
        **抽象方法：**生育；
移动方法:
传入周围空cell坐标，返回其中一个空cell坐标。
        **Animal返回值方法：**进食*/

public abstract class Animal{
    private int ageLimit;
    private final int breedableAge;
    private int age;
    private boolean isAlive = true;

    public Animal(int ageLimit, int breedableAge){
        this.ageLimit = ageLimit;
        this.breedableAge = breedableAge;
    }

    protected int getAge(){
        return age;
    }

    protected double getAgePercent(){
        return (double)age/ageLimit;
    }

    public abstract Animal breed();

    public void grow(){
        age++;
        if(age > ageLimit){
            die();
        }
    }

    private void die() {
        isAlive = false;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public boolean isBreedable(){
        return age >breedableAge;
    }

    public Location move(Location[] freeAdj){
        Location ret = null;
        if( freeAdj.length > 0 && Math.random() < 0.02 ){
            ret = freeAdj[(int)(Math.random()*freeAdj.length)];
        }
        return ret;
    }

    @Override
    public String toString(){
        return " "+age+":"+(isAlive?"live":"dead");
    }

    public Animal feed(ArrayList<Animal> neighbour){
        return null;
    }

    protected void longerlife( int addage ){
        ageLimit += addage;
    }
}