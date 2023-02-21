package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class stringSum {
    public static void main(String[] args) {
       new stringSum().solution(String[]strings,5);
    }

    public String[] solution (String[]strings,int n){
        String[] answer = new String[strings.length];

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            arr.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1);
        }
        return answer;
    }
}
