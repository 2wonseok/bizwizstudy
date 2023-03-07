package prog;
import java.util.HashMap;

public class prog_230307 {

    // 단체사진 찍기

    //import java.util.HashMap;

    class Solution {
        HashMap<Character, Integer> hm; // 모든 구성원의 정보를 담을 HashMap
        boolean[] visited;              // 8개의 방문여부를 확인하기 위함
        int[] ch;                       // 각 경우의 번호를 담을 배열
        int answer;                     // 가능한 개수 카운트

        public int solution(int n, String[] data) {
            hm = new HashMap<>();
            visited = new boolean[8];
            ch = new int[8];
            answer = 0;
            // HashMap초기화
            hm.put('A', 0);
            hm.put('C', 1);
            hm.put('F', 2);
            hm.put('J', 3);
            hm.put('M', 4);
            hm.put('N', 5);
            hm.put('R', 6);
            hm.put('T', 7);
            // 0번째 인덱스부터 깊이우선 탐색
            dfs(0, data);

            return answer;
        }

        public void dfs(int idx, String[] data) {
            // 끝까지 도달했으면서 data의 모든 조건을 만족할 경우 answer증가
            if (idx == 8 && check(data)) answer++;
            else {
                for (int i = 0; i < 8; i++) {
                    // 방문하지 않은 i가 있을 경우
                    if (!visited[i]) {
                        visited[i] = true;  // 방문처리
                        ch[idx] = i;        // 임시저장할 ch에 현재 값 저장
                        dfs(idx + 1, data); // 다음 인덱스 깊이우선 탐색
                        visited[i] = false; // 방문처리 해제
                    }
                }
            }
        }

        public boolean check(String[] data) {
            // 모든 조건을 탐색
            for (String s : data) {
                int a = ch[hm.get(s.charAt(0))];    // 첫번째 사람
                int b = ch[hm.get(s.charAt(2))];    // 두번째 사람
                int res = Character.getNumericValue(s.charAt(4)) + 1;   // 얼만큼 떨어져있을지

                switch (s.charAt(3)) {
                    case '=':   // 두 문자사이의 간격이 res와 같지 않으면 거짓
                        if (Math.abs(a - b) != res) return false;
                        break;
                    case '>':   // 두 문자 사이의 간격이 res보다 작을 경우 거짓
                        if (Math.abs(a - b) <= res) return false;
                        break;
                    case '<':   // 두 문자 사이의 간격이 res보다 클 경우 거짓
                        if (Math.abs(a - b) >= res) return false;
                        break;
                }
            }
            // 위의 모든 조건을 통과했을 경우 참 리턴
            return true;
        }
    }




}
