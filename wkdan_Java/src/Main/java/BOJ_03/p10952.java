package BOJ_03;

import java.io.*;
import java.util.StringTokenizer;

public class p10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 1;; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x != 0 && y != 0) {
                bw.write(x + y + "\n");
            } else {
                break;

            }
        }
        bw.flush();
        bw.close();
    }
}