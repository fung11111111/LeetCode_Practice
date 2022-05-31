package array;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//leetecode 44
//todo not fix yet

public class WildcardPattern {
    public boolean isMatch(String s, String p) {
        List<String> subList = new ArrayList<>();

        int startIdx = 0;
        //substring >= begin && < end
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                if (i == 0) {
                    subList.add(p.substring(startIdx, i + 1));
                    startIdx = i + 1;
                } else {
                    subList.add(p.substring(startIdx, i));
                    subList.add(p.substring(i, i + 1));
                    startIdx = i + 1;
                }

            }
        }
        if (startIdx < p.length()) {
            subList.add(p.substring(startIdx, p.length()));
        }

        if (subList.size() == 1) {
            boolean res = true;
            String sub = subList.get(0);
            if (sub.length() != s.length()) return false;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) == s.charAt(i) || sub.charAt(i) == '?') {
                    continue;
                } else {
                    res = false;
                }
            }
            return res;
        }
//        for(String sub: subList){
//            System.out.println(sub);
//        }

        int endIdx = 0;
        List<Boolean> indicator = new ArrayList<>();
        for (int i = 0; i < subList.size(); i++) {
            String sub = subList.get(i);
            int subIdx = 0;
            if (sub.equals("*")) {
                indicator.add(true);
                if (i < subList.size() - 1) {
                    String nextSub = subList.get(i + 1);
                    String matched = "";
                    int preJ = -1;
                    for (int j = endIdx; j < s.length(); j++) {
                        if (subIdx < nextSub.length()) {
                            System.out.println("s char " + s.charAt(j));
                            System.out.println("next: " + nextSub.charAt(subIdx));
                            System.out.println("next sub: " + nextSub);
                            System.out.println("pre and current j: " + preJ + " current " + j);
                            if (s.charAt(j) == nextSub.charAt(subIdx) || nextSub.charAt(subIdx) == '?') {
                                if (preJ == -1 || j - preJ == 1) {
                                    matched += nextSub.charAt(subIdx) == '?' ? '?' : s.charAt(j);
                                    subIdx++;
                                    preJ = j;
                                }
                            }else {
                                preJ = -1;
                                matched = "";
                            }

                            System.out.println("matched : " + matched);
                        }

                        if (matched.equals(nextSub)) {
                            System.out.println("matched : " + matched);
                            endIdx = j + 1;
                            i = i + 1;
                            indicator.add(true);
                            break;
                        }

//                        if (j == s.length() - 1) {
//                            return false;
//                        }
                    }
                }
            } else {
                String matched = "";
                System.out.println(sub);
                int preJ = -1;
                for (int j = endIdx; j < s.length(); j++) {
                    System.out.println(sub);
                    if (subIdx < sub.length()) {
                        if (s.charAt(j) == sub.charAt(subIdx) || sub.charAt(subIdx) == '?') {
                            if (preJ == -1 || j - preJ == 1) {
                                matched += sub.charAt(subIdx) == '?' ? '?' : s.charAt(j);
                                subIdx++;
                                preJ = j;
                            }
                        }else {
                            preJ = -1;
                            matched = "";
                        }
                    }

                    if (matched.equals(sub)) {
                        endIdx = j + 1;
                        indicator.add(true);
                        break;
                    }
                }
            }

        }

        System.out.println(indicator.size());
        System.out.println(subList.size());

        return indicator.size() == subList.size();
    }
}
