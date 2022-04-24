package backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

//leetcode 17
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int c = Character.getNumericValue(digits.charAt(i));
            numList.add(Integer.valueOf(c));

        }

        char[] arr = new char[numList.size()];
        generatePattern(arr, 0, numList, result);


        return result;
    }

    public List<Character> getCharterInPhone(Integer num) {
        List<Character> characters = new ArrayList<>();
        if (num.equals(1)) {
            return characters;
        }

        if (num.equals(2)) {
            characters.add('a');
            characters.add('b');
            characters.add('c');
            return characters;
        } else if (num.equals(3)) {
            characters.add('d');
            characters.add('e');
            characters.add('f');
            return characters;
        } else if (num.equals(4)) {
            characters.add('g');
            characters.add('h');
            characters.add('i');
            return characters;
        } else if (num.equals(5)) {
            characters.add('j');
            characters.add('k');
            characters.add('l');
            return characters;
        } else if (num.equals(6)) {
            characters.add('m');
            characters.add('n');
            characters.add('o');
            return characters;
        } else if (num.equals(7)) {
            characters.add('p');
            characters.add('q');
            characters.add('r');
            characters.add('s');
            return characters;
        } else if (num.equals(8)) {
            characters.add('t');
            characters.add('u');
            characters.add('v');
            return characters;
        } else if (num.equals(9)) {
            characters.add('w');
            characters.add('x');
            characters.add('y');
            characters.add('z');
            return characters;
        }

        return characters;
    }

    public void generatePattern(char[] arr, int position, List<Integer> numList, List<String> result) {
        if (position == arr.length) {
            result.add(String.valueOf(arr));
        } else {
            Integer num = numList.get(position);
            List<Character> characters = getCharterInPhone(num);
            if (!characters.isEmpty()) {
                for (Character c : characters) {
                    arr[position] = c;
                    generatePattern(arr, position + 1, numList, result);
                }
            }
        }
    }

}
