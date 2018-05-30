package org.yeremy.leetcode.algorithms;

public class OneEditDistance
{
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int count = 0;

        if (Math.abs(m - n) > 1) return false;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                // More than one change
                if (count == 1)
                    return false;

                if (m > n) { // A character was deleted
                    i++;
                }
                else if (n > m) { // A character was added
                    j++;
                }
                else { // A character was changed
                    i++;
                    j++;
                }

                count++;
            }

            else {
                i++;
                j++;
            }
        }

        // If last character is extra
        // in any string
        if (i < m || j < n)
            count++;

        return count == 1;
    }
}
