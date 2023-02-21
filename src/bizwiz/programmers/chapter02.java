package bizwiz.programmers;


import java.util.*;
import java.util.regex.Pattern;


public class chapter02 {

    public static void main(String[] args) {
        String str = "pPoooyY";
        int n =1000;
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
        List<Integer> list =new ArrayList<>();
        return answer;
    }
    boolean solution4(String s) {
        int pnum=0;
        int ynum=0;
        char[] chars = s.toCharArray();
        for (char a :chars){
            if('P'==a|| 'p'==a){
                pnum++;
            }else if('Y'==a|| 'y'==a){
                ynum++;
            }
        }
        return pnum==ynum  ;
    }


}
