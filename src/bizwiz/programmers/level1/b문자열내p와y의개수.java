package bizwiz.programmers.level1;

public class b문자열내p와y의개수 {

    public static void main(String[] args) {


        System.out.println(solution("pPoooyYkdlsadsmdkfnmdkfdkfeippY"));


    }

    public static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        for (char c : s.toCharArray()) {
            if(Character.toString(c).equalsIgnoreCase("p")) {
                pCount += 1;
            } else if (Character.toString(c).equalsIgnoreCase("y")) {
                yCount += 1;
            }
        }

        return pCount == yCount;
    }

}
