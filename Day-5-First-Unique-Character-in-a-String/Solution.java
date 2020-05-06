/**
 * Day 5 - First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples: 
 *  s = "leetcode", return 0.
 *  s = "loveleetcode", return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * Tip: Extra count array (faster in submit) / HashMap
*/

class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c : chars){
            count[(int)c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++){
            if (count[(int)chars[i] - 'a'] == 1)
                return i;         
        }
        return -1;  
      /*  
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        for(int i = 0; i<s.length(); i++){
            if(count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
        */
    }
}