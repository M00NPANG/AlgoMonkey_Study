큰 수, 작은 수를 한 쪽으로 몰려고 하다 보니까 처음에는 temp 써서 값 바꿨었는데,
생각해 보니까 그렇게 안 풀어도 될 것 같다... 
더 쉽고 간결한 방법이 있었음 왜 이런 건 처음으로 생각해 낼 수 없는 거지;


```java
class Solution1 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            //만약에 첫번째 배열의 값이 두번째 배열의 값보다 크면 값을 바꾼다
            if (sizes[i][0] > sizes[i][1]) {
                int temp = 0;
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        //[i][0](작은 수만 모여있음), [i][1](큰 수만 모여있음)
        //여기서 최댓값 찾기
        for (int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(sizes[i][0], maxWidth);
            maxHeight = Math.max(sizes[i][1], maxHeight);
        }
        
        return maxWidth * maxHeight;
    }
}


class Solution2 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            //width를 해당 명함의 가로와 세로 중 큰 값으로 설정
            //height를 해당 명함의 가로와 세로 중 작은 값으로 설정
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            
            //현재까지의 maxWidth와 현재 명함의 width 중 큰 값으로 갱신
            maxWidth = Math.max(maxWidth, width);
            //현재까지의 maxHeight와 현재 명함의 height 중 큰 값으로 갱신
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxWidth * maxHeight;
    }
}

```