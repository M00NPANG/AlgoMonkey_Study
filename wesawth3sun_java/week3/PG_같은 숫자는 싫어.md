문제 상세 해설 ^.^
https://velog.io/@suunn001/%EA%B0%99%EC%9D%80-%EC%88%AB%EC%9E%90%EB%8A%94-%EC%8B%AB%EC%96%B4-java


    import java.util.*;

    
    public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();

        result.add(arr[0]);
        //일단 index 0번 집어넣고 그 후에 비교 시작하기
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        //ArrayIndexOutOfBoundsException 터질 수 있으니 주의
        answer = result.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        //Integer::parseInt는 String 타입의 인자만 직접 int로 변환
        //Integer::intValue는 Integer 객체에서 int 값을 추출하여 반환

        return answer;
    }
}