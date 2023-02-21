package prog;

public class prog_230221 {

    //소수 찾기
    import java.util.*;

    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] arr = new int[n+1];
            for (int i = 2; i <= n; i++) {
                if(arr[i] == 0){
                    answer++;

                    for (int j=i; j<=n; j=j+i) {
                        arr[j] = 1;
                    }
                }
            }
            return answer;
        }
    }


    //서울에서 김서방 찾기
    class Solution {
        public String solution(String[] seoul) {
            String answer = "";

            for(int i=0; i<seoul.length;i++){
                if(seoul[i].equals("Kim")){
                    answer = "김서방은 "+i+"에 있다";
                }
            }
            return answer;
        }
    }


}
