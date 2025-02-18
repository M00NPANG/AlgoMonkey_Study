package 프로그래머스완전탐색.모음사전;

// 이게 맞나요..? ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅌㅋㅋ
// 너무 하드코딩으로 구현해서..
// 당연히 안될줄 알고 다 뜯어 고쳐야겠다 했는데 통과해버렸네요 ㅎㅎㅎ;;
// 다른 분들 보고 배우겠습니다 하핳..

class Solution {
    public int solution(String word) {
        int answer = 0;

        int length = word.length();
        switch (length) {
            case 1:
                return Dictionary1(word.charAt(0));
            case 2:
                int case2Num1 = Dictionary1(word.charAt(0));
                return case2Num1 + Dictionary2(word.charAt(1));
            case 3:
                int case3Num1 = Dictionary1(word.charAt(0));
                int case3Num2 = Dictionary2(word.charAt(1));
                return case3Num1 + case3Num2 + Dictionary3(word.charAt(2));
            case 4:
                int case4Num1 = Dictionary1(word.charAt(0));
                int case4Num2 = Dictionary2(word.charAt(1));
                int case4Num3 = Dictionary3(word.charAt(2));
                return case4Num1 + case4Num2 + case4Num3 + Dictionary4(word.charAt(3));
            case 5:
                int case5Num1 = Dictionary1(word.charAt(0));
                int case5Num2 = Dictionary2(word.charAt(1));
                int case5Num3 = Dictionary3(word.charAt(2));
                int case5Num4 = Dictionary4(word.charAt(3));
                return case5Num1 + case5Num2 + case5Num3 + case5Num4 + Dictionary5(word.charAt(4));
        }

        return answer;
    }

    public int Dictionary1(char word) {
        return switch (word) {
            case 'A' -> 1;
            case 'E' -> 782;
            case 'I' -> 1563;
            case 'O' -> 2344;
            case 'U' -> 3125;
            default -> -1;
        };
    }

    public int Dictionary2(char word) {
        return switch (word) {
            case 'A' -> 1;
            case 'E' -> 157;
            case 'I' -> 313;
            case 'O' -> 469;
            case 'U' -> 625;
            default -> -1;
        };
    }

    public int Dictionary3(char word) {
        return switch (word) {
            case 'A' -> 1;
            case 'E' -> 32;
            case 'I' -> 63;
            case 'O' -> 94;
            case 'U' -> 125;
            default -> -1;
        };
    }

    public int Dictionary4(char word) {
        return switch (word) {
            case 'A' -> 1;
            case 'E' -> 7;
            case 'I' -> 13;
            case 'O' -> 19;
            case 'U' -> 25;
            default -> -1;
        };
    }

    public int Dictionary5(char word) {
        return switch (word) {
            case 'A' -> 1;
            case 'E' -> 2;
            case 'I' -> 3;
            case 'O' -> 4;
            case 'U' -> 5;
            default -> -1;
        };
    }
}