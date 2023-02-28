package bizwiz.programmers.level1;

public class c약수의합 {

    public static void main(String[] args) {
        solution(12);
    }

    public static int solution(int n) {
        int answer = 0;


        for (int i = 1; i <= n; i++) {
            if(n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

}
