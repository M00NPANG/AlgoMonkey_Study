```java

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0; // 가장 가벼운 사람의 인덱스
        int j = people.length - 1; // 가장 무거운 사람의 인덱스
        int boats = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) { 
                i++; // 함께 탈 수 있으면 가벼운 사람 태움
            }
            j--; // 항상 무거운 사람은 태움
            boats++;
        }

        return boats;
    }
}
```