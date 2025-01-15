package BOJ_03;

import java.io.*;

public class p2438 {
    public static void main(String[] args ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i ++) {
            bw.write(("*").repeat(i)+"\n");

        }
        bw.flush();
        bw.close();
    }
}
