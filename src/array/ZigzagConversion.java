package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        boolean reverse = false;
        String output = "";
        int rowIdx = 1;
        Map<Integer, ArrayList> indxMap = new HashMap();

        //rodIdx to rowNum
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indxMap.containsKey(Integer.valueOf(rowIdx))) {
                ArrayList list = indxMap.get(rowIdx);
                list.add(c);
                indxMap.put(Integer.valueOf(rowIdx), list);
            } else {
                ArrayList list = new ArrayList();
                list.add(c);
                indxMap.put(Integer.valueOf(rowIdx), list);
            }

            if (rowIdx == 1) {
                reverse = false;
            }
            if (rowIdx == numRows) {
                reverse = true;
            }

            if (reverse) {
                rowIdx--;
            } else {
                rowIdx++;
            }
        }
        for (int i = 1; i <= numRows; i++) {
            if (indxMap.containsKey(i)) {
                ArrayList list = indxMap.get(i);
                for (int j = 0; j < list.size(); j++) {
                    output += list.get(j);
                }
            }
        }


        return output;
    }
}
