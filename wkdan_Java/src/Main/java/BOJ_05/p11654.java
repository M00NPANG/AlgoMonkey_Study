package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        char a = n.charAt(0);
        int result = (int) a;
        bw.write(result+"");
        bw.flush();
        bw.close();

    }
}
