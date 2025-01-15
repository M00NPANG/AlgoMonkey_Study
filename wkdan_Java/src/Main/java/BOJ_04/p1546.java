package BOJ_04;

import java.io.*;
import java.util.StringTokenizer;

public class p1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            arr[i] = Double.parseDouble(st.nextToken());
        }

        double m = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i]/m)*100;
            sum += arr[i];
        }

        bw.write(sum/n+"\n");

        bw.flush();
        bw.close();
    }
}
