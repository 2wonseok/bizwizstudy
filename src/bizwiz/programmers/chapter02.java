package bizwiz.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class chapter02 {

    public static void main(String[] args) {

    }

    /*
        1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
        (1은 소수가 아닙니다.)

        n은 2이상 1000000이하의 자연수입니다.

        못 풀어서 검색함 ㅠ
     */
    public static int solution07(int n) {
        int answer = 0;
        int[] numbers = new int[n+1];

        for(int i = 2; i <= n; i++) {
            numbers[i] = i;
        }

        for(int i = 2; i < n; i++) {

            if(numbers[i] == 0) {
                continue;
            }

            for(int j = 2 * i; j <= n; j+=i) {
                numbers[j] = 0;
            }
        }

        for(int i = 0; i < numbers.length; i++) {

            if(numbers[i] != 0) {
                answer++;
            }
        }

        return answer;
    }

    /*
        String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
        seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
        seoul은 길이 1 이상, 1000 이하인 배열입니다.
        seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
        "Kim"은 반드시 seoul 안에 포함되어 있습니다.

     */
    public static String solution08(String[] seoul) {
        String answer = "김서방은 index에 있다";
        for (int i = 0; i < seoul.length; i++) {
            if("Kim".equals(seoul[i])) {
                answer = answer.replace("index", String.valueOf(i));
                break;
            }
        }
        return answer;
    }
    /*
        문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
        예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
        s는 길이 1 이상, 길이 8 이하인 문자열입니다.
        s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.

     */
    public boolean solution09(String s) {
        boolean answer = false;
        boolean isNumeric =  s.matches("[+-]?\\d*(\\.\\d+)?");
        if(s.length() == 4 || s.length() == 6) {
            if(isNumeric) {
                answer = true;
            }
        }
        return answer;
    }

    /*
        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
        str은 길이 1 이상인 문자열입니다.
     */
    public static String solution10(String s) {
        String answer = "";
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuffer sb = new StringBuffer(new String(charArr));
        answer = sb.reverse().toString();
        return answer;
    }

    /*
        대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
        다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
        예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
        문자열 s의 길이 : 50 이하의 자연수
        문자열 s는 알파벳으로만 이루어져 있습니다.
     */
    boolean solution11(String s) {
        String[] strArr = s.split("");
        int yLength = 0;
        int pLength = 0;
        for (String str: strArr) {
            if("y".equalsIgnoreCase(str)) {
                yLength++;
            }
            if("p".equalsIgnoreCase(str)) {
                pLength++;
            }
        }
        if(yLength != pLength) {
            return false;
        }
        /*
            Best 풀이
            s = s.toUpperCase();
            return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
         */
        return true;
    }

    /*
        문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
        예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
        strings는 길이 1 이상, 50이하인 배열입니다.
        strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
        strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
        모든 strings의 원소의 길이는 n보다 큽니다.
        인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     */
    public String[] solution11(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        for (String s: strings) {
            String str = s.substring(n,n+1) + s;
            list.add(str);
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }
}
