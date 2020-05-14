/**
 * Day 14 - Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 *  Trie trie = new Trie();
 *  trie.insert("apple");
 *  trie.search("apple");   // returns true
 *  trie.search("app");     // returns false
 *  trie.startsWith("app"); // returns true
 *  trie.insert("app");   
 *  trie.search("app");     // returns true
 * 
 * Note:
 *  You may assume that all inputs are consist of lowercase letters a-z.
 *  All inputs are guaranteed to be non-empty strings.
 * */

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        
        TrieNode cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        if (word == null || word.length() == 0) {
            return false;
        }
        
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */