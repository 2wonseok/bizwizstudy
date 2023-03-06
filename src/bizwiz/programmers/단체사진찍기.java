package bizwiz.programmers;

public class 단체사진찍기 {
    public static void main(String[] args) {
        String[] datas = new String[2];
        datas[0] = "N~F=0";
        datas[1] = "R~T>2";
        System.out.println(solution(2,datas));
    }
    /*
        각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.

        입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다.
        data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.
        1 <= n <= 100
        data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.
        첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T} 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다. 첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.
        두 번째 글자는 항상 ~이다.
        네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
        다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
     */

    private static int answer = 0;
    private static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(String names, boolean[] isVisited, String[] datas) {
        if (names.length() == 7) {
            if (check(names, datas)) { // 조건만족 체크
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) { // 조합
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    // 조건대로 섰는지 체크
    private static boolean check(String names, String[] datas) {
        for (String data : datas) {
            int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
            int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
            char op = data.charAt(3); // 수식
            int index = data.charAt(4) -'0'; // 간격
            /*
                CharAt(int index)로 추출한 숫자형 문자는 char형이므로 int형으로 변환 시 아스키코드로 변환된다.
                따라서 '0'(48)을 빼주어야 의도한 리턴값을 얻을 수 있다.
             */
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) { //둘 포지션 차이를 구하기 위해선 index+1 을 해야함에 주의
                    return false;
                }
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) {
                    return false;
                }
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
