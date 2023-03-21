package prog;
import java.util.*;

public class prog_230321 {

    //124 나라의 숫자

    class Solution {
        public String solution(int n) {
            // String answer = "";
            int num = 0;
            StringBuilder sb = new StringBuilder();
            while(n>0){
                num = n%3;
                n/=3;
                if(num==0){
                    num=4;
                    n-=1;
                }
                //answer = num+answer;
                sb.insert(0, num);
            }
            return sb.toString();
        }
    }


}
