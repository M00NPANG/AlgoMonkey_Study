package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String x = br.readLine();

        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += x.charAt(i) - '0';
        }
        bw.write(sum+"");

        bw.flush();
        bw.close();
    }
}