package bizwiz.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        // bfs 탐색
        bfs(maps, visited);
        // 도착지 값을 넣어주기
        answer = visited[maps.length-1][maps[0].length-1];

        // 갈 수 없다면 -1리턴
        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    private static void bfs(int[][] maps, int[][] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        visited[0][0] = 1; // 시작 위치 방문체크

        while(!queue.isEmpty()){
            int[] current = queue.poll(); // or .remove();
            int cX = current[0];
            int cY = current[1];

            // 4방탐색
            for(int i = 0; i < 4; i++){
                // 이동했을 때 위치
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                // 좌표가 maps에서 벗어날 경우 다음 반복으로 넘어간다
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1) {
                    continue;
                }

                // 아직 방문하지 않았고, 벽이 아닐 경우
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }
    }

}