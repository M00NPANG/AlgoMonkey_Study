package BOJ_01;

import java.io.*;

public class p18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());
        int answer = year-543;

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}