package week3.notebook;

import java.util.HashMap;
import java.util.Scanner;
//HashTable
public class Coin {
    private HashMap<Integer,String> coinnames= new HashMap<Integer,String>();
    public Coin() {
        coinnames.put(1,"penny");
        coinnames.put(10,"dime");
        coinnames.put(25,"quarter");
        coinnames.put(50,"half-dollar");
        coinnames.put(50,"五毛");
        System.out.println(coinnames.keySet().size());//keySet方法获取散列表中所有键的集合
        System.out.println(coinnames);//HashTable有toString方法，可以直接输出，{1=penny, 50=五毛, 25=quarter, 10=dime}
        //HashTable的遍历
        //keySet方法获取散列表中所有键的集合，遍历键值
        for(Integer key : coinnames.keySet()){
            System.out.println(coinnames.get(key));
        }
    }
    public String getName(int amount){
        //containsKey方法判断散列表中是否存在某个键
        if(coinnames.containsKey(amount)){
            //jdk5开始提供包装类的自动装箱和自动拆箱（自动基本类型和包装类类型之间的转换）
            return coinnames.get(amount);
        }else{
            return "Not Found";
        }
    }
    public static void main(String[] args) {
        Coin coin = new Coin();
        Scanner in = new Scanner(System.in);
        String name = coin.getName(in.nextInt());
        System.out.println(name);
    }
}
