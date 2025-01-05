package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p10871 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int [] arr = new int[x];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]<y) {
                result = arr[i];
                bw.write(result+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}