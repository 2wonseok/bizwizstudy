package bizwiz.programmers.level1;

public class c수박수박수박수박수박수 {
    public static void main(String[] args) {
        solution(12);
    }

    public static String solution(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {
            answer += i % 2 == 0 ? "박" : "수";
        }

        return answer;
    }
}
