package leetcode;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();

        int ss = -1,pp = -1;
        int sIndex = 0,pIndex = 0;

        while(sIndex<chars.length){
            if(pIndex == charp.length){//false，回溯
                if(pp == -1) return false;

                pIndex = pp+1; sIndex = ss++;
            }
            else if(charp[pIndex] == '?' || chars[sIndex] == charp[pIndex]){//相同
                pIndex++;sIndex++;
            }else if(charp[pIndex] == '*'){
                pp = pIndex;ss = sIndex;pIndex = pp+1;
            }else{
                if(pp == -1) {
                    return false;
                }
                pIndex = pp+1;sIndex = ss++;
            }
        }
        while(pIndex<charp.length){
            if(charp[pIndex] != '*') {
                break;
            }
            pIndex++;
        }
        return pIndex == charp.length;
    }
}