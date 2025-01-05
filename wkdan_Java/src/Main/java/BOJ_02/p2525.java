package BOJ_02;

import java.io.*;
import java.util.StringTokenizer;

public class p2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int x = H * 60 + M;
        int y = x + m;

        if (y/60 >= 24 ) {
            bw.write(y/60 - 24 + " " + Math.abs(y%60));
        } else {
            bw.write((y / 60) + " " + Math.abs(y % 60) + "\n");
        }
        bw.flush();
        bw.close();
    }
}