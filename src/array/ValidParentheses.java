package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// leetcode 20
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList stack = new LinkedList();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0 || (Character) stack.pop() != '(') return false;
            } else if (c == '}' ) {
                if (stack.size() == 0 ||(Character) stack.pop() != '{') return false;
            } else if (c == ']') {
                if (stack.size() == 0 ||(Character) stack.pop() != '[') return false;
            }
        }


        return stack.size() == 0;
    }
}
