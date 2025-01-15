package BOJ_04;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int[10];

        for (int i=0; i <arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine())%42;
        }
        int count = 1;
        Arrays.sort(arr);
        for (int i=1; i<arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                count++;
            }
        }
        bw.write(count+"");

        bw.flush();
        bw.close();
    }
}