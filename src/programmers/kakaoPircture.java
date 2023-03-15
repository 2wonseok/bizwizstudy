package programmers;

import java.util.*;

public class kakaoPicture {

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

}
