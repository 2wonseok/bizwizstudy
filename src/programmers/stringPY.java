package programmers;

import java.util.*;

public class stringPY {

    public static void main(String[] args) {
        new stringPY().solution("polybee");

    }
    boolean solution (String str){
        boolean answer = true;

        char tag = ' ';

        int count = 0;

        str = str.toLowerCase();
        char[] c = str.toCharArray();
        System.out.println(Arrays.toString(c));
        for (int i=0; i<str.length(); i++) {
            if (tag == 'p' || tag == 'P') {
                count++;
        }
            else if (tag == 'y' || tag == 'y') {
                count++;
            }
        }
      		if(count != 0){
                return false;
            }
        return answer;
    }

}
