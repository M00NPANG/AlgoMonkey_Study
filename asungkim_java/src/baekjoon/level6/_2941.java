package baekjoon.level6;

import java.util.Scanner;

public class _2941 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr={"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                s=s.replaceAll(arr[i],"A");
            }
        }

        System.out.println(s.length());
    }
}
