package bizwiz.programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class chapter01 {
    /* 프로그래머스 과제 제출 코드
        1. 나누어 떨어지는 숫자 배열
            array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
            divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
        제한사항
            arr은 자연수를 담은 배열입니다.
            정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
            divisor는 자연수입니다.
            array는 길이 1 이상인 배열입니다.
     */
    public int[] solution01(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            if(i%divisor == 0) {
                list.add(i);
            }
        }

        Collections.sort(list);

        if(list.isEmpty()) {
            list.add(-1);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    /*
        2. 두 정수 사이의 합
            두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
            예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
        제한사항
            a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
            a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
            a와 b의 대소관계는 정해져있지 않습니다.
     */
    public long solution02(int a, int b) {
        long answer = 0;

        if (a <= b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
        } else {
            for (int i = b; i <= a; i++) {
                answer += i;
            }
        }

        return answer;
    }

    /*
        3. 같은 숫자는 싫어
            배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
            arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
            arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
            배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
        제한사항
            배열 arr의 크기 : 1,000,000 이하의 자연수
            배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
     */
    public int[] solution03(int []arr) {
        ArrayList<Integer> list = new ArrayList();

        int j = -1;

        for(int i = 0; i < arr.length; i++){
            if(j != arr[i]){
                j = arr[i];
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    /*
        4. 가운데 글자 가져오기
            단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
        제한사항
            s는 길이가 1 이상, 100이하인 스트링입니다.
     */
    public String solution04(String s) {
        String answer = "";
        int num =  s.length() / 2 ;
        int mod = s.length() % 2;
        if(mod == 0) {
            answer = s.substring(num-1,num+1);
        } else {
            char c = s.charAt(num);
            answer = String.valueOf(c);
        }

        return answer;
    }

    /*
        5. 2016년
        2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
        요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
        제한사항
            2016년은 윤년입니다.
            2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
     */
    public String solution05(int a, int b) {
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        System.out.println(date);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
        return answer;
    }

    /*
        6. 포켓몬
            설명이 너무 복잡함.
     */
    public int solution06(int[] nums) {
        int answer = 0;
        int a = nums.length / 2;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            list.add(nums[j]);
        }
        list = list.stream().distinct().collect(Collectors.toList());
        if(list.size() >= a) {
            answer = a;
        } else {
            answer = list.size();
        }
        return answer;
    }
}
