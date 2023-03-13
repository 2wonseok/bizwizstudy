package prog;
import java.util.HashMap;

public class prog_230307 {

    // 컬러링북

    class Solution {
        // 변수 접근을 위한 전역 변수들.
        static int numberOfArea;
        static int maxSizeOfOneArea;
        // 한 영역의 수를 저장하는 변수.
        static int temp_cnt = 0;
        // 좌표에서의 상,하,좌,우 탐색을 위한 배열.
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};

        // DFS 메소드
        public static void dfs(int x,int y, int[][] picture, boolean[][] check){
            // 6. 방문한 적 있는 좌표라면 DFS 종료.
            if(check[x][y]) return;

            // 7. 처음 방문 시 방문처리.
            check[x][y] = true;
            // 8. 영역의 수 증가.
            temp_cnt++;

            // 9. 한 좌표에서 상,하,좌,우 탐색.
            for(int i =0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 10. picture 배열의 범위를 벗어나면 continue.
                if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length) continue;

                // 11. 현 좌표의 색 == 상,하,좌,우 좌표의 색 && 방문한적 없는 상,하,좌,우 좌표라면.
                if(picture[x][y] == picture[nx][ny] && !check[nx][ny]){
                    // 12. DFS를 위한 재귀호출.
                    dfs(nx,ny,picture,check);
                }
            }
        }

        public int[] solution(int m, int n, int[][] picture) {
            // 1. 초기화 꼭! 하기.
            numberOfArea =0;
            maxSizeOfOneArea=0;
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            // 2. DFS시 방문여부를 체크 할 배열.
            boolean[][] check = new boolean[m][n];

            // 3. 주어진 picture 배열을 탐색.
            for(int i =0;i<m;i++){
                for(int j=0;j<n;j++){
                    // 4. 원소가 0이 아니고, 방문한 적이 없다면.
                    if(picture[i][j] != 0 && !check[i][j]){
                        // 5. 영역의 수가 1개 증가하며 DFS 탐색 수행.
                        numberOfArea++;
                        dfs(i,j,picture,check);
                    }
                    // 13. 한 영역의 탐색이 모두 끝났다면, 조건에 따라 최대 영역의 수를 변경.
                    if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
                    // 14. 한 영역의 수는 다시 초기화.
                    temp_cnt = 0;
                }
            }

            // 15. 각 값을 answer 배열에 담아주고 끝.
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            return answer;
        }
    }



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
