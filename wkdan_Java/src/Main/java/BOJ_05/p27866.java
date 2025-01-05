package BOJ_05;

import java.io.*;

public class p27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        int n = Integer.parseInt(br.readLine());
        char charValue = a.charAt(n-1);

        bw.write(charValue+"");
        bw.flush();
        bw.close();
    }
}
