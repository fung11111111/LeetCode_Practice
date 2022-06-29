package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetCode 3
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        LinkedList stack1 = new LinkedList();
        LinkedList stack2 = new LinkedList();
        LinkedList longestStack = new LinkedList();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (stack1.size() > 0) {
                char top = (char) stack1.pop();
                if (top == c) {
                    break;
                }
                stack2.addLast(top);
            }
            stack2.addFirst(c);
            stack1 = (LinkedList) stack2.clone();

            if (stack1.size() > longestStack.size()) {
                longestStack = (LinkedList) stack1.clone();
            }
            stack2.clear();
        }


        return longestStack.size();
    }

    public int lengthOfLongestSubstring2(String s){
        Set<Character> characterSet = new HashSet<>();
        int idx = 0;
        int max = 0;
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            while(characterSet.contains(c)){
                characterSet.remove(s.charAt(idx++));
            }
            characterSet.add(c);
            max = Math.max(max, characterSet.size());
        }


        return max;
    }
}
