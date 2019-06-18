package main.java.ArrayList;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid){
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int temp = deepSearch(grid, i, j);
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }

    public static int deepSearch(int[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            int num = 1 + deepSearch(grid, i-1, j) + deepSearch(grid, i+1 , j)
                    + deepSearch(grid, i, j-1) + deepSearch(grid, i, j+1);
            return num;
        } else{
            return 0;
        }
    }

    public static void main(String[] Args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int maxArea = maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }
}
