package bizwiz.programmers;

public class 게임맵최단거리 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] dx2 = {-1,1,0,0};
    static int[] dy2 = {0,0,1,-1};
    static int temp_cnt = 0;
    static int temp_cnt2 = 0;
    public static void main(String[] args) {
        int[][] maps ={{1,0,1,1,1},
                       {1,0,1,0,1},
                       {1,0,1,1,1},
                       {1,1,1,0,1},
                       {0,0,0,0,1}};
                      /* {{1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}};*/
        new 게임맵최단거리().solution(maps);
    }


    public int solution(int[][] maps) {
        int answer = 0;
        boolean [][] check =new boolean[maps.length][maps[0].length];
//        boolean [][] bfsc =new boolean[maps.length][maps[0].length];
        dfs(0,0,maps,check);
        check =new boolean[maps.length][maps[0].length];
        bfs(0,0,maps,check);

        answer =temp_cnt < temp_cnt2 ? temp_cnt :temp_cnt2;
        if (!check[maps.length-1][maps[0].length-1] ){
            answer=-1;
            System.out.println("출구가없어연"+answer);
        }else {
        System.out.println("최단거리="+answer);
        }
        return answer;
    }

    public static void dfs(int x,int y, int[][] maps, boolean[][] check){
        if(check[x][y]){
            return;
        }
        if(check[maps.length-1][maps[0].length-1]){
            return;
        }
        check[x][y] = true;
        temp_cnt++;
        for(int i =0;i<4;i++){
            int nx = x + dy[i];
            int ny = y + dx[i];
            if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length){
                continue;
            }
            if(maps[nx][ny]==1 && !check[nx][ny]){
                dfs(nx,ny,maps,check);
            }
        }

    }

    public void bfs(int y,int x, int[][] maps, boolean[][] check){
        if(check[y][x]){
            return;
        }
        if(check[maps.length-1][maps[0].length-1]){
            return;
        }
        check[y][x] = true;
        temp_cnt2++;
        for(int i =0;i<4;i++){
            int ny = y + dy2[i];
            int nx = x + dx2[i];
            if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length){
                continue;
            }
            if(maps[ny][nx]==1 && !check[ny][nx]){
                bfs(ny,nx,maps,check);
            }
        }
    }
}
