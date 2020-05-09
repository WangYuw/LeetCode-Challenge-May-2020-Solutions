/**
 * Day 9 - Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False. 
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1: Input: 16 Output: true
 * Example 2: Input: 14 Output: false
 * 
 * Tip: Binary Search, attention overflow
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int res = num / mid, con = num % mid;
            if(res == mid && con == 0) return true; // if mid*mid -> long
            if(res < mid) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}