package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int[30];

        for (int i=0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x-1] = 1;
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 1) {
                bw.write((i+1)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}