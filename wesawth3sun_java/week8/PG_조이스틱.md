아니 근데 뭔 놈의 사람 이름에 A가 연속으로 있을 수가 있는 거임
그런 이름이 어딨어
;;

```java
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 최소 커서 이동 (오른쪽으로 쭉), 마지막은 커서 이동할 필요 없다

        for (int i = 0; i < name.length(); i++) {
            // 1. 알파벳 변경 횟수 계산
            char c = name.charAt(i);
            // 'A' = 65, 'Z' = 90 M = 77 -> A, N = 78 -> Z 에서 빼야 더 적게 걸린다
            answer = answer + Math.min(c - 'A', 'Z' - c + 1);
            
            // 2. 연속된 'A' 탐색 -> 이걸 생각 못했다
            // 'A'는 변경할 필요가 없지만, 커서 이동 경로에 따라 전체 조작 횟수가 달라짐
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // 3. 최소 이동 경로 계산
            // i * 2 는 중간까지 갔다가 다시 처음까지 돌아오는 왕복 이동 횟수 + 끝에서부터 A 직전까지 움직이는 이동 횟수 (length - next)
            move = Math.min(move, i * 2 + (name.length() - next)); // 오른쪽 → 왼쪽 (처음에서 시작해 오른쪽으로 스타트, A를 만나면 왼쪽으로 돌아가겠다)
            // (name.length() - next) * 2 끝에서 왼쪽으로 A 직전까지 갔다가 돌아오는 왕복 이동 횟수 + i (처음부터 오른쪽으로 A 전까지 직선 이동)
            move = Math.min(move, (name.length() - next) * 2 + i); // // 왼쪽 → 오른쪽 (끝에서 시작해 왼쪽으로 스타트, A를 만나면 오른쪽으로 돌아가겠다)
        }
        answer += move; // 알파벳 변경 + 최소 이동
        return answer;
    }
}
    
```
    