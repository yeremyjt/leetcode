package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> [] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char element = board[i][j];
                    int boxIndex = (i / 3) * 3 + j / 3;

                    if (rows[i].contains(element) || columns[j].contains(element) || boxes[boxIndex].contains(element))
                        return false;

                    rows[i].add(element);
                    columns[j].add(element);
                    boxes[boxIndex].add(element);
                }
            }
        }

        return true;
    }
}
