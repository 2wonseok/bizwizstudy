package bizwiz.programmers;


import java.util.*;


public class chapter02 {

    public static void main(String[] args) {
        String str = "ZbcdAefgCdC";
        new chapter02().solution(str);
    }
    public String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars,Collections.reverseOrder());
        answer = new String(chars);
        return answer;
    }


}
