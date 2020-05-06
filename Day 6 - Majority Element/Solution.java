/**
 * Day 6 - Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Example 1: Input: [3,2,3], Output: 3
 * Example 2: Input: [2,2,1,1,1,2,2], Output: 2
 * 
 * Tip: HashMap / Sorting / Divide and Conquer / Boyer-Moore Voting Algorithm
*/

class Solution {
    public int majorityElement(int[] nums) {
        /** Sorting
        Arrays.sort(nums);
        return nums[nums.length/2];
        */

        //Boyer-Moore Voting Algorithm
        int count = 0;
        int candidate = nums[0];
        for(int i : nums){
            if(count == 0) candidate = i;
            count += (i == candidate)? 1 : -1;
        }
        return candidate;
    }
}