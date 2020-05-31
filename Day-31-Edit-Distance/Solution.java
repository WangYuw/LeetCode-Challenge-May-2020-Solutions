/**
 * Day 31 - Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *  Insert a character
 *  Delete a character
 *  Replace a character
 *
 * Example 1:
 *  Input: word1 = "horse", word2 = "ros"
 *  Output: 3
 *  Explanation: 
 *      horse -> rorse (replace 'h' with 'r')
 *      rorse -> rose (remove 'r')
 *      rose -> ros (remove 'e')
 *
 * Example 2:
 *  Input: word1 = "intention", word2 = "execution"
 *  Output: 5
 *  Explanation: 
 *      intention -> inention (remove 't')
 *      inention -> enention (replace 'i' with 'e')
 *      enention -> exention (replace 'n' with 'x')
 *      exention -> exection (replace 'n' with 'c')
 *      exection -> execution (insert 'u')
 *
 * Tip: DP
 * 
 * */
 
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        char[] w1 = word1.toCharArray(); 
        char[] w2 = word2.toCharArray();
        return calcMinDist(memo, w1, w2, word1.length()-1, word2.length()-1);
    }
    public int calcMinDist(int[][] memo, char[] w1, char[] w2, int i, int j){
        if(i<0) 
            return j+1;
        if(j<0) 
            return i+1;
        if(memo[i][j]>0) 
            return memo[i][j];
        if(w1[i]==w2[j]) 
            return memo[i][j] = calcMinDist(memo, w1, w2, i-1, j-1);
        return memo[i][j] = 1 + Math.min(
            Math.min(calcMinDist(memo, w1, w2, i, j-1), calcMinDist(memo, w1, w2, i-1, j)), 
            calcMinDist(memo, w1, w2, i-1, j-1));
    }
}