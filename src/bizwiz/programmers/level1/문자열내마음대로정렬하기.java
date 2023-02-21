package bizwiz.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

    public static void main(String[] args) {


        String[] strings = {"abce", "abcd", "cdx"};
//        String[] strings = {"sun", "bed", "car"};
        System.out.println(Arrays.toString(solution(strings, 2)));

    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = {};

        
        // 나의 풀이
        Arrays.sort(strings);
        answer = Arrays.stream(strings).sorted(Comparator.comparing(a -> a.charAt(n))).toArray(String[]::new);

        //답보고 생각한 풀이
//        Arrays.sort(strings);
//        Arrays.sort(strings, Comparator.comparing(a -> a.charAt(n)));

        return answer;
    }

}
