package prog;

public class prog_230214 {

    //폰켓몬
    import java.util.HashMap;
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashMap<Integer,Integer> ponketmon = new HashMap();
            for(int num: nums){
                ponketmon.put(num,ponketmon.getOrDefault(num,0)+1);
            }

            if(ponketmon.size() > nums.length/2){
                answer = nums.length/2;
            }
            else {
                answer = ponketmon.size();
            }
            return answer;
        }
    }

    //두 정수 사이의 합 ★
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;

            if(a <= b){
                for(int i=a; i<=b; i++){
                    answer +=i;
                }
            }else{
                for(int i=b; i<=a; i++){
                    answer +=i;
                }
            }
            return answer;
        }
    }

    //나누어 떨어지는 숫자 배열 ★
    import java.util.*;

    class Solution {
        public int[] solution(int[] arr, int divisor) {

            int cnt = 0;
            int num = 0;

            for(int i = 0; i < arr.length; i++){
                if(arr[i] % divisor == 0){
                    cnt++;
                }
            }

            if(cnt == 0){
                int[] answer = {-1};
                return answer;
            }

            int[] answer = new int[cnt];

            for(int i = 0; i < arr.length; i++){
                if(arr[i] % divisor == 0){
                    answer[num] = arr[i];
                    num++;
                }
            }

            Arrays.sort(answer);
            return answer;

        }
    }

    //같은 숫자는 싫어
    import java.util.ArrayList;

    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            ArrayList<Integer> arrList = new ArrayList<Integer>();

            int num = -1;
            for(int i=0; i<arr.length; i++){
                if(arr[i] != num){
                    arrList.add(arr[i]);
                    num = arr[i];
                }
            }

            answer = new int[arrList.size()];
            for(int i=0; i<answer.length; i++){
                answer[i] = arrList.get(i);
            }

            return answer;
        }
    }

    //2016년
    class Solution {
        public String solution(int a, int b) {

            String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
            int[] date = {31,29,31,30,31,30,31,31,30,31,30,31};
            int sel = 0;

            for(int i = 0; i < a-1; i++){
                sel += date[i];
            }
            sel += b - 1;

            return day[sel % 7];
        }
    }

    //가운데 글자 가져오기
    class Solution {
        public String solution(String s) {
            String answer = "";
            int length = s.length();

            if(length % 2 == 0) {
                answer = s.substring(length/2-1, length/2+1);
            } else {
                answer = s.substring(length/2, length/2+1);
            }
            return answer;
        }
    }


}
