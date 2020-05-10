/**
 * Day 8 - Check If It Is a Straight Line
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
 * Check if these points make a straight line in the XY plane.
 * 
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * 
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * 
 * Constraints:
 *  2 <= coordinates.length <= 1000
 *  coordinates[i].length == 2
 *  -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 *  coordinates contains no duplicate point.
 * 
 * Tip: If there're only 2 points, return true. 
 *      Check if all other points lie on the line defined by the first 2 points.
 *      Use cross product to check collinearity.
 * 
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        for(int i = 2; i < coordinates.length; i++){
            int xi = coordinates[i][0], yi = coordinates[i][1];
            int xj = coordinates[i-1][0], yj = coordinates[i-1][1];
            if((xi-xj)*(y1-y0) != (yi-yj)*(x1-x0)) return false;
        }
        return true;
    }
}