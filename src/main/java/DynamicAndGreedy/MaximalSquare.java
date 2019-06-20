package main.java.DynamicAndGreedy;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length < 1){
            return 0;
        }

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }

        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }

        return max*max;
    }

    public static void main(String[] Args){
        char[][] matrix = {{'1', '0', '1', '0', '0'},{'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
        int max = maximalSquare(matrix);
        System.out.println(max);
    }
}
