package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            int index = x - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
