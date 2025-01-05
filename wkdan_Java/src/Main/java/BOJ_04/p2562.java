package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int[9];
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int m = arr[0];
        int maxCount = 1;

        for (int i=0; i<arr.length; i++) {
            if (arr[i]>m) {
                m = arr[i];
                maxCount = i+1;
            }
        }
        bw.write(m+"\n"+maxCount);

        bw.flush();
        bw.close();
    }
}