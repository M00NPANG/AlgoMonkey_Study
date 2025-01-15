package BOJ_05;

import java.io.*;

public class p1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().trim();

        if (str.isEmpty()) {
            bw.write(0 + "\n");

        } else {
            String[] words = str.split(" ");
            bw.write(words.length + "\n");
        }
        bw.flush();
        bw.close();
    }
}
