/**
 * Day 17 - Find All Anagrams in a String
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * 
 * Example 1: 
 *  Input: s: "cbaebabacd" p: "abc" 
 *  Output: [0, 6]
 *  Explanation:
 *      The substring with start index = 0 is "cba", which is an anagram of "abc".
 *      The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2: 
 *  Input: s: "abab" p: "ab" 
 *  Output: [0, 1, 2]
 *  Explanation:
 *      The substring with start index = 0 is "ab", which is an anagram of "ab".
 *      The substring with start index = 1 is "ba", which is an anagram of "ab".
 *      The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Tip: Sliding Window
 * 
 * */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[26];
        for(int i = 0; i < p.length(); i++)
            count[p.charAt(i) - 'a']++;
        int start = 0, end = 0;
        while(end < s.length()){
            if(count[s.charAt(end) - 'a'] > 0){
                count[s.charAt(end) - 'a']--;
                end++;
                if(end - start == p.length()) result.add(start);
            } else if(start == end){
                start++;
                end++;
            } else {
                count[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return result;
    }
}