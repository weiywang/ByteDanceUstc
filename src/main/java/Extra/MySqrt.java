package main.java.Extra;

public class MySqrt {
    public static int mySqrt(int x) {
        double a = 1.0;
        double diff;

        do{
            a = (x / a + a) / 2.0;
            diff = Math.abs(a * a - x);
        }while (diff > 0.1);//为什么是大于0.1 ？ 只有在diff大于0.1的情况下才继续执行循环体

        return (int) a;
    }

    public static void main(String[] Args){
        int x = 8;
        int res = mySqrt(x);
        System.out.println(res);
    }
}
