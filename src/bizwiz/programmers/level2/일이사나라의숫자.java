package bizwiz.programmers.level2;

public class 일이사나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(13));
    }

    public static String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        while(n!=0){

            if (n % 3 != 0){
                sb.insert(0, n % 3);
            } else{
                sb.insert(0, "4");
                n --;
            }
            n /= 3;
        }
        answer = sb.toString();

        return answer;
    }
}
