package array;

//leetcode 5
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String output = "";

        int maxLength = 0;
        int longestStart = 0;
        int longestEnd = 0;


        for (int i = 0; i < s.length(); i++) {
            boolean isInit = false;

            if (i == 0) {
                isInit = true;
            }

            //abba
            if (i != s.length() - 1) {
                // even search
                int evenStart = i;
                int evenEnd = i + 1;
                while (evenStart >= 0 && evenEnd <= s.length() - 1 && s.charAt(evenStart) == s.charAt(evenEnd)) {
                    if (!isInit) {
                        evenStart--;
                    }
                    evenEnd++;
                }

                if ((evenEnd - evenStart + 1) > maxLength) {
                    maxLength = evenEnd - evenStart + 1;
                    longestStart = isInit ? 0 : evenStart + 1;
                    longestEnd = evenEnd -1 ;
                }

                // odd search
                int oddStart = i - 1;
                int oddEnd = i + 1;
                while (oddStart >= 0 && oddEnd <= s.length() - 1 && s.charAt(oddStart) == s.charAt(oddEnd)) {
                    if (!isInit) {
                        oddStart--;
                    }
                    oddEnd++;
                }
                if ((oddEnd - oddStart + 1) > maxLength) {
                    maxLength = oddEnd - oddStart + 1;
                    longestStart = isInit ? 0 : oddStart + 1;
                    longestEnd = oddEnd - 1 ;
                }
            }
        }

        if (!s.substring(longestStart, longestEnd + 1).isEmpty()) {
            return s.substring(longestStart, longestEnd + 1);
        }


        return output;
    }
}
