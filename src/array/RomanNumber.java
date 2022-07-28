package array;

import java.util.HashMap;
import java.util.Map;

//leetcode 13
public class RomanNumber {


    public void client() {

        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));


    }


    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 5000);
        map.put('M', 1000);

        Integer result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i< s.length() -1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            } else {
                result += map.get(s.charAt(i));
            }

        }


        return result.intValue();
    }

}
