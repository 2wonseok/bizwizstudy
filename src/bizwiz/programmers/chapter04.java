package bizwiz.programmers;

import java.util.*;

public class chapter04 {
    public static void main(String[] args) {
        int m =6;
        int n =4;
        int[][] picture ={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

     new chapter04().solution(6,4,picture);
    }
    /*문제 설명
    카카오 프렌즈 컬러링북
    출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다.
    여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고
    그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
    그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.*/


    public int[] solution(int m, int n, int[][] picture) {
        HashSet hash =new HashSet();
        Map<Integer,Integer> map =new HashMap<>();
        for (int i =0 ;i<m;i++){
            for (int j =0;j<n;j++){
                if(i==0 && j==0){
                    hash.add(picture[i][j]);
                    map.put(picture[i][j],1);
                }else {
                    if(!hash.add(picture[i][j])){
                        int a = map.get(picture[i][j])+1;
                        map.put(picture[i][j],a);
                    }else {
                        hash.add(picture[i][j]);
                        map.put(picture[i][j],1);
                    }
                }

            }
        }
        System.out.println(hash.size());
        System.out.println(map.toString());

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];


        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int recursion(int num){
            if(num==0){
                return 0;
            }



        return recursion(num-1);
    }




}

