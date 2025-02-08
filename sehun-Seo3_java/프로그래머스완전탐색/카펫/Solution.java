package 프로그래머스완전탐색.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

//        우선 이 문제에서 yellow 카펫을 먼저 배열할 경우의 수를 구하고, 각각의 경우의 수에서
//        yellow 를 brown 이 감싸고 있을 때, 개수가 일치하다면 그때의 카펫의 가로와 세로 크기가 정답입니다.

        // rowY (yellow 가로길이)가 1부터 yellow의 제곱근까지 하나씩 검사
        for (int rowY = 1; rowY <= Math.sqrt(yellow); rowY++) {
            if (yellow % rowY == 0) { // yellow 의 약수인지 확인
                int columnY = yellow / rowY; // columnY (yellow 세로 길이)

                // yellow 의 가로와 세로에 각각 2씩 더해서 전체 카펫 크기 계산
                int totalColumn = columnY + 2;
                int totalRow = rowY + 2;

                // brown 타일 수가 일치하는지 계산
                int areaB = totalColumn * totalRow - yellow;
                if(brown == areaB){
                    answer = new int[] {totalColumn,totalRow};
                    break;
                }
            }
        }

        return answer;
    }
}