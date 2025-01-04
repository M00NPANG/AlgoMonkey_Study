package BOJ_05;

import java.io.*;

public class p2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();

        bw.write(a.length()+"");
        bw.flush();
        bw.close();
    }
}