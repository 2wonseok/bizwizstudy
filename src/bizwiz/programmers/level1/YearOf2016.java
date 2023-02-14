package bizwiz.programmers.level1;

import java.util.Calendar;

public class YearOf2016 {

    public static void main(String[] args) {
        System.out.println(getDayOfTheWeek(5,24));


    }

    public static String getDayOfTheWeek(int month, int day) {
        String answer = "";
        String[] days = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < month - 1; i++) {
            allDate += date[i];
        }

        allDate += (day - 1);
        answer = days[allDate % 7];

        return answer;
    }


}
