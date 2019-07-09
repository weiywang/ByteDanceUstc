package main.java.ArrayList;

public class FindCircleNum {
    public static int findCircleNum(int[][] M) {
        if(M.length == 0){
            return 0;
        }
        int[] marks = new int[M.length];
        int total = 0;
        for(int i = 0; i < M.length; i++){
            if(marks[i] != 1){
                total++;

                dfs(M, marks, i);
            }
        }
        return total;
    }

    public static void dfs(int[][] M, int[] marks, int i){
        marks[i] = 1;

        for(int j = 0; j < M[i].length; j++){
            if(M[i][j] == 1 && marks[j] != 1){
                dfs(M, marks, j);
            }
        }
    }

    public static void main(String[] Args){
        int[][] M = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(M));
    }
}
