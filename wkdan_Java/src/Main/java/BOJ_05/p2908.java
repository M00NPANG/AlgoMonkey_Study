package BOJ_05;

import java.io.*;
import java.util.StringTokenizer;

public class p2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int reverseX = 0;
        int reverseY = 0;

        int tempX = x;
        int tempY = y;

        while (tempX > 0) {
            int digit = tempX % 10;
            reverseX = reverseX * 10 + digit;
            tempX /= 10;
        }

        while (tempY > 0) {
            int digit = tempY % 10;
            reverseY = reverseY * 10 + digit;
            tempY /= 10;
        }
        int result = 0;

        if (reverseX > reverseY) {
            bw.write(reverseX+"\n");
        } else {
            bw.write(reverseY+"\n");
        }

        bw.flush();
        bw.close();
    }
}
