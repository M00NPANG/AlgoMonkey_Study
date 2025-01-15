package BOJ_03;

import java.io.*;

public class p25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int a = 0;

        a = n/4;

        bw.write("long ".repeat(a)+"int"+"\n");

        bw.flush();
        bw.close();
    }
}
