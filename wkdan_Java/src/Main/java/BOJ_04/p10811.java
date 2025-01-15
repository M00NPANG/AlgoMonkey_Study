package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while (a<b) {
                int temp = arr[a - 1];
                arr[a - 1] = arr[b - 1];
                arr[b - 1] = temp;
                a++;
                b--;
            }

        }
        for (int i=0; i<arr.length; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}