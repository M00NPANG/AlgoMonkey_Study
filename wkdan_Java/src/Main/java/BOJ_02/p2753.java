package BOJ_02;

import java.io.*;

public class p2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n%4==0 && (n%100)!=0 || n%400==0) {
            bw.write(1+"\n");
        } else {
            bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
    }
}
