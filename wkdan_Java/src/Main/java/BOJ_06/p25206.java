package BOJ_06;

import java.io.*;
import java.util.StringTokenizer;

public class p25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double totalCredits = 0;
        double totalGrades = 0;
        int subjects = 0;

        for (int i=0; i<20; i++) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            double gradePoint = 0;

            switch (grade) {
                case "A+":
                    gradePoint = 4.5;
                    break;
                case "A0":
                    gradePoint = 4.0;
                    break;
                case "B+":
                    gradePoint = 3.5;
                    break;
                case "B0":
                    gradePoint = 3.0;
                    break;
                case "C+":
                    gradePoint = 2.5;
                    break;
                case "C0":
                    gradePoint = 2.0;
                    break;
                case "D+":
                    gradePoint = 1.5;
                    break;
                case "D0":
                    gradePoint = 1.0;
                    break;
                case "F":
                    gradePoint = 0;
                    break;
            }
            totalCredits += credit;
            totalGrades += credit*gradePoint;
            subjects++;
        }
        double averageCredits = totalGrades / totalCredits;
        bw.write(averageCredits+"\n");

        bw.flush();
        bw.close();
    }
}
