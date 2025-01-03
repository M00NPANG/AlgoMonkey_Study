package baekjoon.level6;

import java.util.Scanner;

public class _25206 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // name score grade

        // 전공평점 = (score * grade) / total(score)


        double totalScore=0;
        double totalOver=0;
        for (int i = 0; i < 20; i++) {
            String[] data = sc.nextLine().split(" ");
            double score=Double.parseDouble(data[1]);
            double grade=gradeToNum(data[2]);

            if (grade<0) continue;

            totalOver+=(score*grade);
            totalScore+=Double.parseDouble(data[1]);
        }

        System.out.println(totalOver/totalScore);
    }

    private static double gradeToNum(String grade) {
        switch (grade) {
            case "A+" : return 4.5;
            case "A0" : return 4.0;
            case "B+" : return 3.5;
            case "B0" : return 3.0;
            case "C+" : return 2.5;
            case "C0" : return 2.0;
            case "D+" : return 1.5;
            case "D0" : return 1.0;
            case "F" : return 0.0;
            default: return -1;
        }
    }
}
