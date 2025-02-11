package Week6;

import java.util.HashSet;
import java.util.Set;

public class PG_42839 {

    public int solution(String numbers){

        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];

        String[] split = numbers.split("");
        generateNumbers("", split, used, set);

        int result = 0;

        for (Integer num : set) {
            if(isPrime(num))
                result++;
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if(num < 2)
            return false;

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0)
                return false;
        }

        return true;
    }

    private static void generateNumbers(String current, String[] cards, boolean[] used, Set<Integer> set)
    {
        if(!current.isEmpty())
            set.add(Integer.parseInt(current));

        for(int i = 0; i < cards.length; i++){
            if(!used[i]){
                used[i] = true;
                generateNumbers(current + cards[i], cards, used, set);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PG_42839 pg42839 = new PG_42839();
        int solution = pg42839.solution("17");
        System.out.println("solution = " + solution);
    }
}
