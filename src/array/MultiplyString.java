package array;

//leetcode 43
public class MultiplyString {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] record = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            int a = num1.charAt(n1 - i - 1) - '0';
            for (int j = 0; j < n2; j++) {
                int b = num2.charAt(n2 - j - 1) - '0';
                record[i + j] += (a * b);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < record.length; i++) {
            sb.append(record[i] % 10);
            if (i != record.length - 1) record[i + 1] += record[i] / 10;
        }
        int count = 0;
        while (sb.length() - 1 - count > 0 && sb.charAt(sb.length() - 1 - count) == '0') count++;
        return sb.reverse().toString().substring(count);
    }

    public void client() {
        String s1 = "1234";
        String s2 = "23";
        System.out.println(multiply(s1, s2));
    }
}
