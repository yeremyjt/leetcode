package org.yeremy.leetcode.algorithms.binarysearch;

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6
 */
public class GuessNumberHigherOrLower {
    private final int NUMBER = 6;
    public int guessNumber(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int low, int high) {
        if (low > high) return high;
        int mid = low + (high - low) / 2;
        int guess = guess(mid);
        if (guess == 0) return mid;
        if (guess == -1) return binarySearch(low, mid -1);
        else return binarySearch(mid + 1, high);
    }

    private int guess(int num) {
        if (NUMBER == num) return 0;
        if (NUMBER < num) return -1;
        else return 1;
    }

}
