package array;

import desingPattern.creationalPattern.SingletonPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLSAInterview {

    public String first() {
        String[] str = new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24", "10.0.0.3 - GET 2020-08-24", "10.0.0.3 - GET 2020-08-24", "10.0.0.4 - GET 2020-08-24"};
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String current = str[i];
            if (m.containsKey(current)) {
                Integer n = m.get(current);
                n += 1;
                m.put(current, n);
            } else {
                m.put(current, 1);
            }
        }

        Integer occ = 0;
        String key = "";
        for (Map.Entry<String, Integer> map : m.entrySet()) {
            if (map.getValue() > occ) {
                occ = map.getValue();
                key = map.getKey();
            }
        }


        return key;
    }

    public String second() {
        String s = "aabccdd";
        Map<Character, Boolean> m = new HashMap<>();
        Map<Character, Integer> idx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!idx.containsKey(s.charAt(i))) {
                idx.put(s.charAt(i), i);
            }

            if (m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), true);
            } else {
                m.put(s.charAt(i), false);
            }
        }
        List<Character> candidate = new ArrayList<>();
        for (Map.Entry<Character, Boolean> ori : m.entrySet()) {
            if (!ori.getValue()) {
                candidate.add(ori.getKey());
            }
        }

        Integer finalIdx = -999;
        for (Character c : candidate) {
            Integer i = idx.get(c);
            if (finalIdx < 0) {
                finalIdx = i;
            } else {
                if (i < finalIdx) {
                    finalIdx = i;
                }
            }
        }

        return String.valueOf(s.charAt(finalIdx));
    }

    public String third() {
        String key = "ote";

        String[] inupt = new String[]{"abc", "def", "toek", "toe"};
        List<String> finalStr = new ArrayList<>();
        for (int i = 0; i < inupt.length; i++) {
            int j = 0;
            while (j < key.length()) {
                if (!inupt[i].contains(String.valueOf(key.charAt(j)))) {
                    break;
                } else {
                    j++;
                }
            }
            if (j == key.length()) {
                finalStr.add(inupt[i]);
            }
        }

        Integer length = 0;
        String result = "";
        for (String s : finalStr) {
            if (s.length() > length) {
                length = s.length();
                result = s;
            }
        }

        return result;
    }


}
