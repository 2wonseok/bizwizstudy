package prog;

public class prog_230228 {

    //자릿수 더하기
//    자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//    예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
    //import java.util.*;

    public class Solution {
        public int solution(int n) {
            int answer = 0;

            String str = Integer.toString(n);

            for(int i=0; i<str.length(); i++){
                answer += Integer.parseInt(str.substring(i, i+1));
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }


    //이상한 문자 만들기
    // "try hello world"	"TrY HeLlO WoRlD"
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] str = s.split("");

            int index = 0;
            for(int i=0; i<str.length; i++) {
                if(str[i].equals(" ")) {
                    index = 0;
                } else if(index % 2 == 0) {
                    str[i] = str[i].toUpperCase();
                    index++;
                } else if(index % 2 != 0) {
                    str[i] = str[i].toLowerCase();
                    index++;
                }
                answer += str[i];
            }

            return answer;
        }
    }


    //수박수박수박수박수?
    class Solution {
        public String solution(int n) {
            String answer = "";
            for(int i=1; i<=n;i++){
                if(i%2 != 0){
                    answer += "수";
                }else{
                    answer += "박";
                }
            }
            return answer;
        }
    }




}
