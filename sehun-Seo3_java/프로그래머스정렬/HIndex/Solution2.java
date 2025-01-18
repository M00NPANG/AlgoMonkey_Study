package 프로그래머스정렬.HIndex;
// 통과는 되었지만.. 이중루프로 시간이 오래걸리고, 별로 좋지않은 코드인것같다..

class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;

        // 브루트포스 방식으로, 모든 논문 순차적으로 조사하는 방식.
        // h-index를 구하기 위해 가능한 모든 값을 0부터 논문개수 까지 순차적으로 조사
        for (int i = 0; i <= citations.length; i++) {
            int count = 0; // 현재 값 i 이상 인용된 논문의 개수
            for (int citation : citations) { // 모든 논문 인용횟수들을 살펴봤을 때,
                if (citation >= i) { // 해당 논문 인용 횟수가 i번 이상일 때,
                    count++; // 카운트 증가.
                }
            }
            // i 이상 인용된 논문의 개수(count)가 i 이상이라면 h-index 조건 만족
            if (count >= i) { //
                // 현재까지 구한 h-index 값과 i를 비교하여 더 큰 값을 선택 -> 즉 i 값들은 잠재적인 h-index 가 된다.
                answer = Math.max(answer, i);
            }
        }

        return answer;
    }
}