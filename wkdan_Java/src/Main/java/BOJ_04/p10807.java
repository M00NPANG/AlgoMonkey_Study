package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<array.length; i++) {

            array[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0;i< array.length; i++) {
            if (array[i] == s) {
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}