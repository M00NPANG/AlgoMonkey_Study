package baekjoon.level6;

import java.util.Scanner;

public class _1316 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int cnt=0;
        for (int i = 0; i < n; i++) {
            String word=sc.next();
            if (isGroup(word)) cnt++;
        }

        System.out.println(cnt);
    }


    // 그룹단어 찾기
    private static boolean isGroup(String s) {
        boolean[] visited=new boolean[26];
        char prev='A';

        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (cur!=prev) {
                if (visited[cur-'a']) {
                    return false;
                }
                prev=cur;
            }
            visited[cur-'a']=true;
        }

        return true;
    }
}
