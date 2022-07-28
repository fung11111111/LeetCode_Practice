package array;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);

        char[] c = s.toCharArray();
        int j = s.length() - 1;
        for (int i = 0; i < c.length / 2; i++) {
            if(c[i] != c[j]) return false;
            j--;
        }


        return true;
    }

    public boolean isPalindrome2(int x){
        if(x < 0 ) return  false;
        StringBuilder builder = new StringBuilder();
        String original = String.valueOf(x);
        builder.append(original);
        builder.reverse();

        return builder.toString().equals(original);

    }

    public void client() {
        int x = 121;
        System.out.println(isPalindrome2(x));
    }
}
