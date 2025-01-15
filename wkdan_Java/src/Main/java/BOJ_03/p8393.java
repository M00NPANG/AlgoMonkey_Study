package BOJ_03;

import java.io.*;

public class p8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
