package bizwiz.programmers.level1;

import java.util.Arrays;

public class aPhonekemon {
    public static void main(String[] args)  {
        int[] Phonekemons = {1,5,2,6,3,4};
        System.out.println(solution(Phonekemons));
    }

    public static int solution(int[] nums) {
        int answer = nums.length / 2;
        int di = (int) Arrays.stream(nums).distinct().count();
        return answer > di ? di : answer;
    }

}
