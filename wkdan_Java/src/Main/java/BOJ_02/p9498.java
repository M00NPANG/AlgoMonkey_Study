package BOJ_02;

import java.io.*;

public class p9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        if (a<=100 && a>=90){
            bw.write("A" + "\n");
        } else if (a<=89 && a>=80){
            bw.write("B" + "\n");
        } else if (a<=79 && a>=70){
            bw.write("C" + "\n");
        } else if (a<=69 && a>=60){
            bw.write("D" + "\n");
        } else {
            bw.write("F" + "\n");
        }
        bw.flush();
        bw.close();
    }
}
