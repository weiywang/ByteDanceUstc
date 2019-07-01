package main.java.String;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    private static List<String> res;

    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        generateIpAddress("", s);
        return res;
    }

    private static void generateIpAddress(String ipAdress, String s){
        int n = 0;
        for(int i = 0; i < ipAdress.length(); i++){
            if(ipAdress.charAt(i) == '.'){
                n++;
            }
        }

        if(n == 3){
            if(ipAdress.length() - 3 < s.length()){
                String lastString = s.substring(ipAdress.length() - 3);
                if(lastString.length() > 3){
                    return;
                }else if(lastString.length() != 1 && lastString.charAt(0) == '0'){
                    return;
                }else if(Integer.valueOf(lastString) >= 0 && Integer.valueOf(lastString) <= 255){
                    res.add(ipAdress + lastString);
                }else{
                    return;
                }
            }else{
                return;
            }
        }

        String[] nextString = new String[3];
        for(int i = 0; i < 3; i++){
            if(ipAdress.length() - n + i + 1 < s.length()){
                nextString[i] = s.substring(ipAdress.length() - n, ipAdress.length() - n + i + 1);
                if(nextString[i].length() != 1 && nextString[i].charAt(0) == '0'){
                    continue;
                }else{
                    if(Integer.valueOf(nextString[i]) >= 0 && Integer.valueOf(nextString[i]) <= 255){
                        generateIpAddress(ipAdress + nextString[i] + ".", s);
                    }
                }
            }else {
                continue;
            }
        }
    }

    public static void main(String[] Args){
        String ipString = "25525511135";
        System.out.println(restoreIpAddresses(ipString).toString());
    }
}
