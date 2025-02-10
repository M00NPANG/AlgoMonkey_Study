package weekendstudy;

import java.util.*;
import java.io.*;

public class BJ_11660 {
//    d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + table[i][j] 부분합 공식 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][N+1]; // 기본 배열
        int[][] sum = new int[N+1][N+1]; // 누적합을 담을 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());

                sum[i][j] = table[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                // 현재 위치 까지의 누적합 계산
                // sum[i-1][j]와 sum[i][j-1] 더하고, 중복된 영역 sum[i-1][j-1] 빼고 현재 값 table[i][j] 더하면 sum[i][j] 크기의 누적합 배열 생성됨
            }
        }
        int answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            answer = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            // sum 배열의 x2,y2까지 누적합을 받아와서 1,1에서 x1, y1 부분 구간 빼주고 중복해서 빠진 구간 더해줌
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}