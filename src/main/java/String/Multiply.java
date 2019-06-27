package main.java.String;

import java.util.Arrays;

public class Multiply {
    public static String multiply(String num1, String num2) {
        String ZERO = "0";
        String ONE = "1";
        if(num1.length() == 0 || num2.length() == 0){
            return ZERO;
        }
        if(num1.equals(ZERO) || num2.equals(ZERO)){
            return ZERO;
        }
        if(num1.equals(ONE)){
            return num2;
        }
        if(num2.equals(ONE)){
            return num1;
        }
        int[] resNum = new int[num1.length() + num2.length() -1];
        Arrays.fill(resNum, 0);
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                resNum[i + j] += (num2.toCharArray()[j] - '0') * (num1.toCharArray()[i] - '0');
            }
        }
        StringBuilder res = new StringBuilder();
        int addIn = 0;
        for(int i = resNum.length - 1; i >= 0; i--){
            int t = resNum[i] + addIn;
            addIn = t / 10;
            res.append(t % 10);
        }
        if(addIn > 0){
            res.append(addIn);
        }
        return res.reverse().toString();
    }

    public static void main(String[] Args){
        String num1 = "2";
        String num2 = "3";
        String res = multiply(num1, num2);
        System.out.println(res);
    }
}
