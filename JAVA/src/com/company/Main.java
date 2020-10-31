package com.company;

class Solution {
    public String solution(int n, int[][] delivery) {
        String answer = "";
        int[] check = new int[1005];

        for(int i = 1 ;i <= n ; i++){
            check[i] = 2;
        }

        //배송완료 체크
        for(int i = 0 ; i <  delivery.length; i++){
            if(delivery[i][2] == 1){
                check[delivery[i][0]] = 1;
                check[delivery[i][1]] = 1;
            }
        }

        //배송 실패
        for(int i = 0 ; i <  delivery.length; i++){
            if(check[delivery[i][0]] == 2 && check[delivery[i][1]] == 2) continue;
            if(delivery[i][2] == 0){
                if(check[delivery[i][0]] == 1){
                    check[delivery[i][1]] = 0;
                }
                else if(delivery[i][1] == 1) {
                    check[delivery[i][0]] = 0;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(check[i] == 0) answer += "X";
            else if(check[i] == 1) answer += "O";
            else answer += "?";
        }
        return answer;
    }
}

public class Main {

//    public static void main(String[] args) {
//        int[][] arr = new int[4][3];
//        arr[0][0] = 1;
//        arr[0][1] = 3;
//        arr[0][2] = 1;
//
//        arr[1][0] = 3;
//        arr[1][1] = 5;
//        arr[1][2] = 0;
//
//        arr[2][0] = 5;
//        arr[2][1] = 4;
//        arr[2][2] = 0;
//
//        arr[3][0] = 2;
//        arr[3][1] = 5;
//        arr[3][2] = 0;
//
//        Solution solution = new Solution();
//
//        solution.solution(6,arr);
//    }
}
