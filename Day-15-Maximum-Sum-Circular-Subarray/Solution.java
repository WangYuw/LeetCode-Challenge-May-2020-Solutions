/**
 * Day 15 - Maximum Sum Circular Subarray
 * 
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * 
 * Here, a circular array means the end of the array connects to the beginning of the array.  
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * Also, a subarray may only include each element of the fixed buffer A at most once.  
 * (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * 
 * Example 1: Input: [1,-2,3,-2] Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * 
 * Example 2: Input: [5,-3,5] Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * 
 * Example 3: Input: [3,-1,2,-1] Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * 
 * Example 4: Input: [3,-2,2,-3] Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * 
 * Example 5: Input: [-2,-3,-1] Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 * 
 * Tip: DP -> Kadane's Algorithm
 * Case 1: max subarray in not circular : normal Kadane's Algorithm
 * Case 2: max subarray is circular : Max - Min_subArray - Max (0 - N-1)
 * 
 * */

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if(A.length == 1) return A[0];
        int sumA = 0;
        for(int a: A) sumA += a;
        int maxMid = kadane(A, 0, A.length-1, 1);
        int maxCyc1 = sumA + kadane(A, 0, A.length-1, -1);
        return maxMid < 0 ? maxMid : Math.max(maxMid, maxCyc1);
    }
    
    private int kadane(int[] A, int i, int j, int sign){
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            currSum = Math.max(currSum, 0) + sign * A[k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}