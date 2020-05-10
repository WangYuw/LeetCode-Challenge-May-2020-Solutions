/**
 * Day 3 - Ransom Note
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * Examples:
 *  canConstruct("a", "b") -> false
 *  canConstruct("aa", "ab") -> false
 *  canConstruct("aa", "aab") -> true
 * 
 * Tip: Extra count Array
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] letters = new int[26];
        for(char c : magazine.toCharArray()){
            letters[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(letters[c - 'a'] == 0) return false;
            letters[c - 'a']--;
        }
        return true;

        /*  
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, letters[c - 'a']);
            if (index == -1) return false;
            letters[c - 'a'] = index + 1;
        }
        return true;
        */
    }
}