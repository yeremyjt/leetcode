package org.yeremy.leetcode.algorithms.string;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new LogSort());
        return logs;
    }

    private class LogSort implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if (comp != 0)
                    return comp;
                else
                    return split1[0].compareTo(split2[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        }
    }
}
