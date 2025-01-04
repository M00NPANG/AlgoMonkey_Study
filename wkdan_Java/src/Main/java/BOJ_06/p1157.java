package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c-'A']++;
        }

        int max = 0;
        char result = ' ';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = (char)(i+'A');
            } else if (arr[i] == max) {
                result ='?';
            }
        }
        bw.write(result+"\n");

        bw.flush();
        bw.close();
    }
}
