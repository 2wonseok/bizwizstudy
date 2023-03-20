package bizwiz.programmers;

/**
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 */
public class 일이사나라의숫자 {
    /**
     * 입력값 / 결과
     *   1      1
     *   2      2
     *   3      4
     *   4      11
     *   5      12
     *   6      14
     *   7      21
     *   8      22
     *   9      24
     *   10     41
     *   11     42
     *   12     44
     */
    public static void main(String[] args) {
        System.out.println(solution(7));
    }

    public static String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        /**
         * StringBuilder도 StringBuffer와 마찬가지로
         *
         * 원하는 위치에 문자열을 추가할 수 있는
         *
         * insert() 메소드를 제공합니다.
         */
        while(n != 0) {
            if (n % 3 == 0){
                sb.insert(0, 4);
                n -= 1;
            } else {
                sb.insert(0, n % 3);
            }
            n /= 3;
        }
        answer = sb.toString();

        return answer;
    }
}
