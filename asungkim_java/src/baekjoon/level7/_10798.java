package baekjoon.level7;

import java.util.Scanner;

public class _10798 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String[][] words=new String[5][15];

        int maxLen=Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            String word=sc.nextLine();
            maxLen= Math.max(maxLen,word.length());
            for (int j = 0; j < word.length(); j++) {
                char c=word.charAt(j);
                words[i][j]=String.valueOf(c);
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (words[j][i]==null) {
                    continue;
                }
                sb.append(words[j][i]);
            }
        }

        System.out.println(sb.toString());
    }
}
