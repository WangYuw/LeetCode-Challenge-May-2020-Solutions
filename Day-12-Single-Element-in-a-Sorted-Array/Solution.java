/**
 * Day 12 - Single Element in a Sorted Array
 * 
 * You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * except for one element which appears exactly once. Find this single element that appears only once.
 * 
 * Example 1: Input: [1,1,2,3,3,4,4,8,8] Output: 2
 * Example 2: Input: [3,3,7,7,10,11,11] Output: 10
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * Tip: Binary Search with XOR (a ^ 1 = a + 1 if even ; a - 1 if odd)
 *  The unique number must be at even position.
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length -1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == nums[mid ^ 1])  
                left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    /*
    public int singleNonDuplicate(int[] nums) {
        int left = 0, len = nums.length, right = len / 2;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[2 * mid] == nums[2 * mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[2 * left];
    } */
}