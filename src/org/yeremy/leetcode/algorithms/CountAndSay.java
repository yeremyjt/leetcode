package org.yeremy.leetcode.algorithms;

public class CountAndSay
{
    public String countAndSay(int n) {
        if (n == 0) return "";

        String[] array = new String[n];
        array[0] = "1";

        for (int i = 1; i < n; i++) {
            array[i] = generate(array[i - 1]);
        }

        return array[n - 1];
    }

    private String generate(String s) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                counter++;
            }
            else {
                sb.append(counter);
                sb.append(s.charAt(i - 1));
            }
        }

        sb.append(counter);
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }
}
