package BOJ_03;

import java.io.*;
import java.util.StringTokenizer;

public class p10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            bw.write(A+B+"\n");
        }
        bw.flush();
        bw.close();
    }
}
