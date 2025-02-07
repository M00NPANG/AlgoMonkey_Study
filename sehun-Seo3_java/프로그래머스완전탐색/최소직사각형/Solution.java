package 프로그래머스완전탐색.최소직사각형;

//  Solution 풀이
//  ...
//  테스트 16 〉	통과 (0.76ms, 93.7MB)
//  테스트 17 〉	통과 (1.41ms, 98.5MB)
//  테스트 18 〉	통과 (1.16ms, 95.4MB)
//  테스트 19 〉	통과 (1.19ms, 84.2MB)
//  테스트 20 〉	통과 (1.80ms, 97.6MB)
//
//  Solution2 풀이
//  ...
//  테스트 16 〉	통과 (2.69ms, 83.7MB)
//  테스트 17 〉	통과 (2.41ms, 102MB)
//  테스트 18 〉	통과 (1.97ms, 84.9MB)
//  테스트 19 〉	통과 (1.90ms, 84.5MB)
//  테스트 20 〉	통과 (2.92ms, 86.2MB)
//
//  처음에 Arrays.sort를 이용해서 풀었는데, 조금 비효율적인것 같아 Solution 대로 풀어봤습니다!
//  사실 당연하겠지만, 속도면에서 Arrays.sort 를 이용한 Solution2보다는 Solution 풀이가 좀 더 빠릅니다..!
//  얼마나 차이나는지 궁금해서 그랬습니다...ㅎㅎ

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int w = 0; // 명함의 가로 길이 w
        int h = 0; // 명함의 세로 길이 h

        // 모든 명함들을 하나씩 조사
        for(int[] size : sizes) {
            // 가로 길이 width 를 높은 값, 세로 길이 height 를 낮은 값으로 분류해서 지갑에 넣을 명함들을 수납하기 용이하게 한다.
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            // 그 중 가장 높은 값을 각각 w, h
            w = Math.max(w, width);
            h = Math.max(h, height);
        }

        // 지갑의 크기 = (가로) x (세로)
        answer = w*h;

        return answer;
    }
}