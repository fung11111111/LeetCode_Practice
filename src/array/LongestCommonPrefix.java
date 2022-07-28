package array;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 14
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String tmpPre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            if (tmpPre.length() <= current.length()) {
                for (int j = 0; j < tmpPre.length(); j++) {
                    if (tmpPre.charAt(j) != current.charAt(j)) {
                        tmpPre = tmpPre.substring(0, j);
                        break;
                    }
                }
            } else {
                if (current.length() == 0) {
                    tmpPre = "";
                }
                for (int j = 0; j < current.length(); j++) {
                    tmpPre = tmpPre.substring(0, current.length());
                    if (tmpPre.charAt(j) != current.charAt(j)) {
                        tmpPre = tmpPre.substring(0, j);
                        break;
                    }
                }
            }


        }

        return tmpPre;
    }

    public String longestCommonPrefixOptimal(String[] strs) {
        String minStr = strs[0];
        for (String s : strs) {
            if (s.length() < minStr.length()) {
                minStr = s;
            }
        }
        int i = 0;
        while (i < strs.length && minStr.length() != 0) {
            if (strs[i].charAt(minStr.length() - 1) != minStr.charAt(minStr.length() - 1)) {
                minStr = minStr.substring(0, minStr.length() - 1);
            }else {
                if(strs[i].contains(minStr)){
                    i++;
                }else {
                    minStr = minStr.substring(0,minStr.length()-1);
                }
            }
        }


        return minStr;
    }

    public void client() {
        String[] input = new String[]{"flower", "flow", "flight"};
        String[] input2 = new String[]{"dog", "racecar", "car"};
        String[] input3 = new String[]{"abab", "aba", ""};

        System.out.println(longestCommonPrefixOptimal(input));
    }
}
