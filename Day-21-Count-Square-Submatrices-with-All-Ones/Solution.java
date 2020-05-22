/**
 * Day 21 - Count Square Submatrices with All Ones
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Example 1:
 * Input: matrix =
 * [  [0,1,1,1],
 *    [1,1,1,1],
 *    [0,1,1,1]  ]
 * Output: 15
 * Explanation: 
 *  There are 10 squares of side 1.
 *  There are 4 squares of side 2.
 *  There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 * Example 2:
 * Input: matrix = 
 * [  [1,0,1],
 *    [1,1,0],
 *    [1,1,0]   ]
 * Output: 7
 * Explanation: 
 *  There are 6 squares of side 1.  
 *  There is 1 square of side 2. 
 *  Total number of squares = 6 + 1 = 7.
 *
 * Constraints:
 *  1 <= arr.length <= 300
 *  1 <= arr[0].length <= 300
 *  0 <= arr[i][j] <= 1
 *
 * Tip: DP. 
 *  Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0). 
 *  Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, 
 *  if it checks then add 1 to the answer.
 * */

class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[][] dp = new int[r][c];
        int sum=0;
        
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0) dp[i][j] =1;
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    sum+=dp[i][j];
                }
            }
        return sum;
    }

    public int countSquares2(int[][] matrix) {
        if(matrix.length==0)
            return 0;
         
        int r = matrix.length;
        int c = matrix[0].length;
         
        int[] prev = new int[c];
        int[] curr = new int[c];
        int sum = 0;
         
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0)
                        curr[j] = 1;
                    else
                        curr[j] = Math.min(Math.min(prev[j], curr[j-1]), prev[j-1]) + 1;
       
                    sum+=curr[j];
                }
            }
             
            prev = curr;
            curr = new int[c];// REMEMBER 
        }
         
        return sum;
    }
}