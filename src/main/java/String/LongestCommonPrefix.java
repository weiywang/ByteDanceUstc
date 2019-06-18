package String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() == 0){
                return "";
            }
        }
        int n = strs.length;
        String result = "";
        for(int j = 0; ;j++){
            char temp = strs[0].toCharArray()[j];
            boolean tempBool = true;
            for(int i = 1;i < n;i++){
                if(strs[i].toCharArray()[j] == temp) continue;
                else {
                    tempBool = false;
                }
            }
            if(tempBool){
                result = strs[0].substring(0, j+1);
            }
            else break;
        }
        return result;
    }

    public static void main(String[] args){
        String[] strs = {"c", "c"};
        System.out.println(longestCommonPrefix(strs));
    }
}
