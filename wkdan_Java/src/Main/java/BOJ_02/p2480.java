package BOJ_02;

import java.io.*;
import java.util.StringTokenizer;

public class p2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a==b && b==c) {
            bw.write(10000 + a *1000 + "\n");
        } else if (a==b || a==c) {
            bw.write(1000 + a *100 + "\n");
        } else if (b==c) {
            bw.write(1000 + c *100 + "\n");
        } else {
            bw.write(Math.max(a,Math.max(b,c))*100 + "\n");
        }
        bw.flush();
        bw.close();
    }
}