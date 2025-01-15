package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p9086 {
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            String[] a = new String[n];

            for (int i=0; i<a.length; i++) {
                a[i] = br.readLine();
            }

            for (int i =0; i<a.length; i++) {
                bw.write(a[i].charAt(0)+""+a[i].charAt(a[i].length()-1)+ "\n");
            }
            bw.flush();
            bw.close();
        }
    }
}
