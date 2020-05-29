/**
 * Day 29 - Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *  Input: numCourses = 2, prerequisites = [[1,0]]
 *  Output: true
 *  Explanation: There are a total of 2 courses to take. 
 *    To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 *  Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 *  Output: false
 *  Explanation: There are a total of 2 courses to take. 
 *      To take course 1 you should have finished course 0, and to take course 0 you should
 *      also have finished course 1. So it is impossible.
 *
 * Constraints:
 *  The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 *  You may assume that there are no duplicate edges in the input prerequisites.
 *  1 <= numCourses <= 10^5
 *
 * Tip: This problem is equivalent to finding if a cycle exists in a directed graph.
 * */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for(int[] edge : prerequisites)
            graph.get(edge[0]).add(edge[1]);

        int[] visit = new int[numCourses]; 
        // 0, if the node is not visited yet.
        // 1, if the DFS exploration has started for the i-th node but not yet completed.
        // -1, if the DFS exploration has both started for the i-th node and completed.

        for(int i = 0; i < numCourses; i++)
            if(visit[i] == 0 && !notCycle(graph, i, visit))
                return false;
        return true;
    }

    public boolean notCycle(List<List<Integer>> graph, int i, int[] visit){
        visit[i] = -1; // start exploration
        for(int node : graph.get(i))
            // if we find -1, this means there is a cycle involving this node in the graph
            // we will only explore if 0, or the node has not been explored.
            if(visit[node] == -1 || visit[node] == 0 && !notCycle(graph, node, visit))
                return false;
        visit[i] = 1; // complete exploration
        return true;
    }
}