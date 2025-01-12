package baekjoon.level1;
import java.util.Scanner;

public class _2588 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a1=sc.nextInt();
        int a2=sc.nextInt();

        int x=a2/100; // 3
        int y=(a2/10)%10; // 8
        int z=a2%10; //5

        int a3=a1*z;
        int a4=a1*y;
        int a5=a1*x;

        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a3+a4*10+a5*100);


    }
}
