package 프로그래머스정렬.가장큰수;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        // 숫자를 문자열로 변환 후 리스트에 추가.
        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            String s = String.valueOf(number);
            list.add(s);
        }

        // 리스트 내림차순 (람다식을 이용해서, 두 숫자를 조합했을 때, 큰 숫자가 되도록 정렬 -> [6, 10, 2] 에서 [6, 2, 10] 으로 정렬
        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 만약 첫 번째 배열(가장 큰 숫자)이 0이라면 "0000" 과 같은 이상한 수가 나오므로, 예외처리를 해야하는 것 같다... 그냥 쓰지ㅜ;
        if(list.get(0).equals("0")) return "0";

        // 문자 하나씩 조합하기.
        for (String s : list) {
            answer += s;
        }

        return answer;
    }
}