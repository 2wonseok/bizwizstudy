package programmers;

import java.util.*;

public class prog20230307 {

    public static void main(String[] args) {

    }
    
    //카카오 프렌즈 컬러링북
    //출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
    //그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
    
    class Solution {
        static int numberOfArea;
        static int maxSizeOfOneArea;
        static int temp_cnt = 0;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        
        // DFS 메소드
        public static void dfs(int x,int y, int[][] picture, boolean[][] check){
            if(check[x][y]) return;
            
            check[x][y] = true;
            temp_cnt++;
            
            for(int i =0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length) continue;
                
                if(picture[x][y] == picture[nx][ny] && !check[nx][ny]){              
                    dfs(nx,ny,picture,check);
                }            
            }        
        }
        
        public int[] solution(int m, int n, int[][] picture) {
            numberOfArea =0;
            maxSizeOfOneArea=0;
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            
            boolean[][] check = new boolean[m][n];
            
            for(int i =0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(picture[i][j] != 0 && !check[i][j]){
                        numberOfArea++;
                        dfs(i,j,picture,check);
                    }
                    if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
                    temp_cnt = 0;
                }
            }
            
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            
            return answer;
        }
    }


    //단체사진 찍기
    //가을을 맞아 카카오프렌즈는 단체로 소풍을 떠났다. 즐거운 시간을 보내고 마지막에 단체사진을 찍기 위해 카메라 앞에 일렬로 나란히 섰다. 
    //그런데 각자가 원하는 배치가 모두 달라 어떤 순서로 설지 정하는데 시간이 오래 걸렸다. 네오는 프로도와 나란히 서기를 원했고, 
    //튜브가 뿜은 불을 맞은 적이 있던 라이언은 튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다. 사진을 찍고 나서 돌아오는 길에, 
    //무지는 모두가 원하는 조건을 만족하면서도 다르게 서는 방법이 있지 않았을까 생각해보게 되었다. 
    //각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.
    class Solution2 {
        static String[] d;
        static HashMap<Character,Integer> map ;
        static boolean[] visited;
        static int[] ch;
        static int answer;
        
        public int solution2(int n, String[] data) {
            d = data;
            map = new HashMap<>();
            visited = new boolean[8];
            ch = new int[8];
            answer = 0;
            map.put('A',0);
            map.put('C',1);
            map.put('F',2);
            map.put('J',3);
            map.put('M',4);
            map.put('N',5);
            map.put('R',6);
            map.put('T',7);
            dfs(0);
            return answer;
        }
        
        public static void dfs(int idx){
            if(idx == 8){
                if(check()) answer++;
            }
            else{
                for(int i=0;i<8;i++){
                    if(!visited[i]){
                        visited[i] = true;
                        ch[idx] = i;
                        dfs(idx + 1);
                        visited[i] = false;
                    }
                }
            }
        }
        
        
        
    
        
        public static boolean check(){
            int a,b,res;
            char op;
            for(String s : d){
                a = ch[map.get(s.charAt(0))];
                b = ch[map.get(s.charAt(2))];
                op = s.charAt(3);
                res = s.charAt(4)-'0' + 1;
                
                if(op == '='){ if(Math.abs(a-b)!=res) return false;}
                else if(op == '>'){ if(Math.abs(a-b) <= res) return false;}
                else {if(Math.abs(a-b) >= res) return false;}
            }
            return true;
        }
    }
}
