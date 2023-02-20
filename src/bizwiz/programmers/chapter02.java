package bizwiz.programmers;


import java.util.*;
import java.util.regex.Pattern;


public class chapter02 {

    public static void main(String[] args) {
        String str = "1234";
        int n =10;
        new chapter02().solution3(n);
    }
    public String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = new char[chars.length];
        for(int i =0;i<chars.length;i++){
            chars2[i] = chars[chars.length-i-1];
        }
        answer = new String(chars2);
        return answer;
    }
    public boolean solution2(String str) {
        boolean answer = Pattern.matches("^[0-9]*$",str);
        if(str.length()!=4 && str.length()!=6){
          answer = false;
        }
        return answer;
    }
    public int solution3(int n) {
        int answer = 0;
        for (int i =1; i<=n;i++){
            if (i%2==0 && i%3==0 && i%5==0 && i%7==0){

            }else{
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }


}
