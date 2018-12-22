package String;

public class LongestSubStr {
	public static int longestSubString(String s){
        int[] m = new int[256];
        char[] ss = s.toCharArray();
        int res = 0, left = 0;
		for(int i = 0; i < ss.length; i++){
			if(m[ss[i]] == 0 || m[ss[i]] < left) res = res > i-left+1 ? res : i-left+1;
			else left = m[ss[i]];
			m[ss[i]] = i+1;
		}
		return res;
	}	
	
	public static void main(String[] args){
		System.out.println(longestSubString("abcabcbb"));
	}

}
