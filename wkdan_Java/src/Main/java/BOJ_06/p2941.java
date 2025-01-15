package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                String c = arr[j];
                if (i + c.length() <= s.length() && s.substring(i, i + c.length()).equals(c)) {
                    count++;
                    i += c.length() - 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        bw.write(count + "\n");


        bw.flush();
        bw.close();
    }
}
