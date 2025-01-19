// 정렬 - H-index(42747번)

package Week5;
import java.util.Arrays;

public class PG_42747 {

    public int solution(int[] citations)
    {
        Arrays.sort(citations);

        int n = citations.length;

        for(int i = 0; i < n; i++){
            if(citations[i] >= n - i){
                return n-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = {3, 0, 6, 1, 5};

        PG_42747 pg42747 = new PG_42747();
        int solution = pg42747.solution(arr);
        System.out.println("solution = " + solution);

    }
}
