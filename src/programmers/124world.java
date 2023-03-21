package programmers;


public class Solution {

    /**
     * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
     * */


    public static void main(String[] args) {
        solution(50000000);
    }
    public static String solution(int n) {
        StringBuffer sb = new StringBuffer();

        while(n > 0) {
            int remainder = n%3;
            if(remainder == 0) {
                sb.append(4);
            } else if(remainder == 1) {
                sb.append(1);
            } else {
                sb.append(2);
            }
            if(remainder == 0)  {
                n -= 1;
            }
            n /= 3;
        }
        return sb.reverse().toString();
    }
}

