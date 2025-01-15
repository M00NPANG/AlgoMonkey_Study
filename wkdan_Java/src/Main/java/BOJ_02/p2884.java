package BOJ_02;

import java.io.*;
import java.util.StringTokenizer;

public class p2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x = H * 60 + M;
        int y = x - 45;

        if (H == 0 && M <45) {
            bw.write("23 "+ (M+15)+"\n");
        } else {
            bw.write((y/60) + " " + Math.abs(y%60)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
