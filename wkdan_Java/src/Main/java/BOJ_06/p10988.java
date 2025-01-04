package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder(s);

        String b = sb.reverse().toString();
        if (s.equals(b)) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }
}
