package main.java.Extra;

public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int totalByteCount = 0;
        for(int item : data){
            if(totalByteCount == 0){
                totalByteCount = computeTotalByteCount(item);

                if(totalByteCount == -1){
                    return false;
                }

                totalByteCount--;
                continue;
            }

            if((item & 0xC0) != 0x80){
                return false;
            }
            totalByteCount--;
        }

        return totalByteCount == 0;
    }


    public int computeTotalByteCount(int item){
        if((item & 0x80) == 0x00){//item & 0x80 == 0x00 这种写法有语法错误
            return 1;
        }
        if((item & 0xE0) == 0xC0){
            return 2;
        }
        if((item & 0xF0) == 0xE0){
            return 3;
        }
        if((item & 0xF8) == 0xF0){
            return 4;
        }
        return -1;
    }
}
