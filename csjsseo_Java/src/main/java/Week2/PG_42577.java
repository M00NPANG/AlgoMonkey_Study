package Week2;

import java.util.HashSet;
import java.util.Set;

public class PG_42577 {

        public boolean solution(String[] phone_book) {

            Set<String> set = new HashSet<>();

            for (String number : phone_book) {
                set.add(number);
            }

            for (String number : set) {
                for (int i = 1; i < number.length(); i++) {
                    if (set.contains(number.substring(0, i)))
                        return false;
                }
            }

            return true;
        }

    public static void main(String[] args) {
        String[] phone_book_1 = {"119","97674223","1195524421"};
        String[] phone_book_2 = {"123","456","789"};
        PG_42577 pg42577 = new PG_42577();
        
        boolean solution_1 = pg42577.solution(phone_book_1);
        System.out.println("solution = " + solution_1);


        boolean solution_2 = pg42577.solution(phone_book_2);
        System.out.println("solution = " + solution_2);
    }
}
