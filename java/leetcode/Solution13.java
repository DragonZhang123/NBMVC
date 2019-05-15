package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  leetcode 13    罗马数字转整数
 * 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * 3、小的数字在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 */
public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] romanNumber = s.toCharArray();
        int value = 0;
        System.out.println(romanNumber.length);
        for (int i = 0; i < romanNumber.length; i++) {
            if (i==romanNumber.length-1 || map.get(romanNumber[i+1]) <= map.get(romanNumber[i]) ){
                value +=map.get(romanNumber[i]);
                System.out.println("/"+value);
            }else {
                value -=map.get(romanNumber[i]);
                System.out.println("/"+value);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println((new Solution13()).romanToInt("IV"));
    }
}
