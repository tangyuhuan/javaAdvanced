package week1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(),in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }
}

//构造表示分数的类Fraction
class Fraction {
    int a; //分子
    int b; //分母
    Fraction(int a,int b)
    {
        this.a = a;
        this.b = b;
    }
    void print()
    {
        int min = a<b?a:b;
        if(a==b)
        {
            System.out.println(1);
            return;
        }
        for(int i=min;i>=1;i--){
            if((a%i==0)&&(b%i==0)){
                System.out.println(a/i+"/"+b/i);
                break;
            }
        }
    }
    double toDouble()
    {
        return (double)a/(double)b;
    }
    Fraction plus(Fraction r)
    {
        int x = this.a*r.b+r.a*this.b;
        int y = this.b*r.b;
        return new Fraction(x,y);
    }
    Fraction multiply(Fraction r)
    {
        int x = this.a*r.a;
        int y = this.b*r.b;
        return new Fraction(x,y);
    }

}
