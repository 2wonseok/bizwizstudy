package bizwiz.programmers.level1;

public class c시저암호 {

    public static void main(String[] args) {
        solution("a B z", 4);
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {

            if(Character.isLowerCase(c)) { //소문자
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if(Character.isUpperCase(c)) { //대문자
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }

            answer.append((char) c);
        }
        
        System.out.println(answer);
        return answer.toString();
    }

}
