package org.yeremy.leetcode.algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s : input.split("\n")){
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"'s
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove all "/t"'s, add"/" at the end
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len - 1); // subtracting the last "/" at the end
        }
        return maxLen;
    }
}
