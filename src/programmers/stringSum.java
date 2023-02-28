package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class stringSum {
    public static void main(String[] args) {
        String[] strs = {"sum","dex","map"};
        new stringSum().solution(strs,1);
    }

    public String[] solution (String[] strings,int n){
        String[] answer = new String[strings.length];

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            arr.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1);
        }
        System.out.println(arr);
        return answer;
    }
}
