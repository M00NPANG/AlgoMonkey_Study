import java.io.*;
import java.util.StringTokenizer;

public class p11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= a; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write("Case #" + i + ": " + x + " + " + y + " = " +(x+y) + "\n");
        }
        bw.flush();
        bw.close();
    }
}