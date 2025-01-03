package baekjoon.level1;
import java.util.Scanner;

public class _10430 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();

        int x1=(A+B)%C;
        int x2=((A%C) + (B%C))%C;
        int x3= (A*B)%C;
        int x4=((A%C) * (B%C))%C;

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);
    }
}
