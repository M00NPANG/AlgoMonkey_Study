package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (k != 1) {
            k = 1-k;
        } else {
            k = 0;
        }
        if (q != 1) {
            q = 1-q;
        } else {
            q = 0;
        }
        if (l != 2) {
            l = 2-l;
        } else {
            l = 0;
        }
        if (b != 2) {
            b = 2-b;
        } else {
            b = 0;
        }
        if (n != 2) {
            n = 2-n;
        } else {
            n = 0;
        }
        if (p != 8) {
            p = 8-p;
        } else {
            p = 0;
        }
        bw.write(k+" "+q+" "+l+" "+b+" "+n+" "+p+"\n");

        bw.flush();
        bw.close();
    }
}
