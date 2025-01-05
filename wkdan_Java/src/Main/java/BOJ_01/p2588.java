package BOJ_01;

import java.io.*;

public class p2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int a = B/100%10;
        int b = B/10%10;
        int c = B%10;

        bw.write(A*c+"\n");
        bw.write(A*b+"\n");
        bw.write(A*a+"\n");
        bw.write(A*B+"\n");
        bw.flush();
        bw.close();
    }
}
