package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write(" ".repeat(n-i-1) + "*".repeat(2*i+1) +"\n");
        }
        for (int i = n-2; 0 < i+1; i--) {
            bw.write(" ".repeat(n-i-1) + "*".repeat(2*i+1) +"\n");
        }

        bw.flush();
        bw.close();
    }
}
