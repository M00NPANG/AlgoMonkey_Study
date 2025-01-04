package BOJ_03;

import java.io.*;

public class p2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<10; i++) {
            bw.write(n + " * " + i + " = " + n*i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
