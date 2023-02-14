package bizwiz.programmers_pcs;
import java.util.*;
/* 
 * 
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
재한사항
	• s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s	return
"abcde"	"c"
"qwer"	"we"

 * 
 */
public class 가운데글자가져오기_담당 {

    public String solution(String s) {
        String answer = "";
        
        boolean isOdd = (s.length() % 2) != 0;
        int idx = s.length() / 2;
        if(isOdd){
            answer = s.substring(idx,idx+1);
        } else {
            answer = s.substring(idx-1,idx+1);
        }
        
        return answer;
    }


}
