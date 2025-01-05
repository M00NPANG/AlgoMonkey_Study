package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String[] str = st.nextToken().split(" ");

            String S = str[0];

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < a; k++) {
                    bw.write(S.charAt(j) + "");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
