package main.java.DynamicAndGreedy;

public class MaxProfitEnhance {
    public static int maxProfit(int[] prices){
        int sum = 0;
        if(prices == null || prices.length < 1){
            return 0;
        }
        int prev = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > prev){
                sum += (prices[i] - prev);
            }
            prev = prices[i];
        }
        return sum;
    }

    public static void main(String[] Args){
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
