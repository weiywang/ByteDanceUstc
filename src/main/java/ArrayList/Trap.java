package ArrayList;

public class Trap {
    public static int trap(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int max = 0, maxIndex = 0;
        for(int i = 0;i < height.length;i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int total = 0;
        int topIndex = 0;

        for(int i = 0;i < maxIndex;i++){
            if(height[topIndex] < height[i]){
                topIndex = i;
            } else{
               total += (height[topIndex] - height[i]);
            }
        }

        topIndex = height.length - 1;
        for(int i = height.length - 1; i > maxIndex; i--){
            if(height[topIndex] < height[i]){
                topIndex = i;
            }else{
                total += (height[topIndex] - height[i]);
            }
        }
        return total;
    }

    public static void main(String[] Args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }
}
