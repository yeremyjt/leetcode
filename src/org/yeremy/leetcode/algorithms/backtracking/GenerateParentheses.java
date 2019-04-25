package org.yeremy.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        return backtrack(ans, "", 0, 0, n);
    }

    private List<String> backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
        return ans;
    }
}
