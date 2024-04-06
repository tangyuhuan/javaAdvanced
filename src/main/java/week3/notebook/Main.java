package week3.notebook;

import java.util.HashMap;
import java.util.Scanner;
//输入
//Hagzou Hugzou Jigxng ###
//0 1108 708
//1108 0 994
//708 994 0
//Hagzou Jigxng

//输出
//708
public class Main {

    public static void main(String[] args) {
        HashMap<String,Integer> city= new HashMap<String,Integer>();
        Scanner in = new Scanner(System.in);
        String scaner = in.next();
        int index=0;
        while(!scaner.equals("###")){
            city.put(scaner,index);
            index++;
            scaner = in.next();
        }
//        System.out.println(city);//{0=ss, 1=ss, 2=sa}
        int[][] arr = new int[city.size()][city.size()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = in.nextInt();
            }
        }
        String a = in.next();
        String b = in.next();
        System.out.println(arr[city.get(a)][city.get(b)]);
    }
}
