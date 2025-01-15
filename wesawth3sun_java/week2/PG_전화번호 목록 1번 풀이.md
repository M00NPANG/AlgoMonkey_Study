import java.util.*;

class Solution {
public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();
        List<Boolean> check = new ArrayList<>();
        //접두어가 있는지 확인하는 리스트
        
        set.addAll(Arrays.asList(phone_book));
        //스트링 배열을 set 구조에 저장 (중복이 없으니까 데이터가 사라질 걱정 x)
        
        for (int i = 0; i < phone_book.length; i++) {
            set.remove(phone_book[i]);
            for (String string : set) {
                if (string.startsWith(phone_book[i])) {
                    check.add(false);
                }
            }
            set.add(phone_book[i]);
        }
        /*set 구조는 데이터 변경이 쉽다.
        자기 자신과 비교하지만 않으면 되니 자기 자신을 먼저 set에서 제거해 주고
        비교가 끝난 후에는 다음 비교를 위해 다시 집어넣어 주는 방법*/
        
        if (check.contains(false)) {
            return false;
        } else {
            return true;
        }
    }
}