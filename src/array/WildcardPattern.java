package array;

public class WildcardPattern {
    public boolean isMatch(String s, String p) {
        boolean res = true;
        if (s.length() == p.length()) {
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                char b = p.charAt(i);
                if (a == b || b == '?' || b == '*') {
                    continue;
                } else {
                    return false;
                }
            }
        } else {
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                char d = p.charAt(left);

                if (c == d || d == '?') {
                    left++;
                    continue;
                }
                if(left < p.length()-1){
                    if (c != d && d == '*' && c != p.charAt(left +1)){
                        continue;
                    }
                }

            }
        }


        return res;
    }
}
