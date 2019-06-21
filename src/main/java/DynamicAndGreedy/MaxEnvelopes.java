package main.java.DynamicAndGreedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public static int maxEnvelopes(int[][] envelopes){
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < envelopes.length; i++){
            int[] end = envelopes[i];
            for(int j = 0; j < i; j++){
                int[] start = envelopes[j];
                if(start[0] < end[0] && start[1] < end[1] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < envelopes.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] Args){
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int result = maxEnvelopes(envelopes);
        System.out.println(result);
    }
}
