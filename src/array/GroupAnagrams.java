package array;

import java.lang.reflect.Array;
import java.util.*;

//leetcode 49
//todo: add solution
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] carray = strs[i].toCharArray();

            Arrays.sort(carray);
            String tmpString = new String(carray);
            if (resultMap.containsKey(tmpString)) {
                resultMap.get(tmpString).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                resultMap.put(tmpString, list);
            }
        }

        resultMap.keySet().stream()
                .forEach(k -> {
                    res.add(resultMap.get(k));
                });


        return res;
    }

}
