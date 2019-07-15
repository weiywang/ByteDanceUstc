package main.java.ArrayList;

import java.util.Arrays;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        int count = 0;
        int[][] res = new int[intervals.length][2];
        int[] last = intervals[0];
        if(intervals.length <= 1){
            return intervals;
        }
        intervals = sort(intervals);

        for(int i = 1; i < intervals.length; i++){
            if(last[1] >= intervals[i][0]){
                last[1] = intervals[i][1];
                res[count] = last;
            } else{
              res[count++] = last;
              last = intervals[i];
            }
        }
        System.out.println(count);
        int[][] realRes = new int[count + 1][2];
        for(int i = 0; i <= count; i++){
            realRes[i] = res[i];
        }
        return realRes;
    }

    public static int[][] sort(int[][] m) {
        int[] m1 = new int[m.length];
        for (int i = 0; i < m1.length; i++) {
            m1[i] = m[i][0] * 10 + m[i][1];
        }
        Arrays.sort(m1);
        for (int i = 0; i < m.length; i++) {
            m[i][0] = m1[i] / 10;
            m[i][1] = m1[i] % 10;
        }
        return m;
    }

    public static void main(String[] Args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
