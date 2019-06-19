package main.java.DynamicAndGreedy;

public class MaxProfit {
    public static int maxProfit(int[] prices){
        int max = 0;
        if(prices == null || prices.length < 1){
            return 0;
        }
        int min = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                if(max < prices[i] - min){
                    max = prices[i] - min;
                }
            }
        }
        return max;
    }

    public static void main(String[] Args){
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
