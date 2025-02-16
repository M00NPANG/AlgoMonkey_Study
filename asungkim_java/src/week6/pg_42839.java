package week6;

import java.util.HashSet;
import java.util.Set;

public class pg_42839 {
    /***
     * 1. 소수 문제이므로 isPrime 구현
     * 2. numbers 가 최대 길이 7이하 이므로 dfs 를 통한 모든 경우의 수 탐색 방법 선택
     * 3. dfs 함수는 빈 문자열이 원하는 길이의 숫자길이가 되었을때 그 수가 소수라면 HashSet에 넣는 함수임
     * 4. for문을 통해 dfs의 길이를 1부터 numebers의 길이만큼의 경우의수를 탐색하고 HashSet 사이즈를 리턴
     */
    private static Set<Integer> set; // 중복 제거를 위한 자료구조 선택
    private static int len; // numebers의 길이
    private static boolean[] visited; // 방문처리
    public int solution(String numbers) {
        len=numbers.length();
        set=new HashSet<>();
        visited=new boolean[len];

        for (int i=1;i<=len;i++) {
            dfs(i,numbers,""); // 숫자 길이가 1부터 len까지의 경우의수 탐색
        }

        return set.size();
    }

    // dfs -> tmp를 numbers로부터 추출해서 길이가 depth 가 되었을때 set에 추가해
    private static void dfs(int depth,String numbers,String tmp) {
        if (depth==tmp.length()) {
            int tmpNum=Integer.parseInt(tmp);
            if (isPrime(tmpNum)) {
                set.add(tmpNum);
            }
            return;
        }

        for (int i=0;i<len;i++) {
            // 백트레킹 방식
            if (!visited[i]) {
                visited[i]=true;
                dfs(depth,numbers,tmp+numbers.charAt(i));
                visited[i]=false;
            }
        }

    }

    // 소수 -> 1과 자신만을 약수로 가지는 수
    private static boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        if (n==2) {
            return true;
        }

        if (n>=3) {
            for (int i=2;i<=Math.sqrt(n);i++) {
                if (n%i==0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
