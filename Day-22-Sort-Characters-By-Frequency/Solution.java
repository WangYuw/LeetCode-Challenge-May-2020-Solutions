/**
 * Day 22 - Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *  Input: "tree"
 *  Output: "eert"
 *  Explanation:
 *      'e' appears twice while 'r' and 't' both appear once.
 *      So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 *  Input: "cccaaa"
 *  Output: "cccaaa"
 *  Explanation:
 *      Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 *      Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 *  Input: "Aabb"
 *  Output: "bbAa"
 *  Explanation:
 *      "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *      Note that 'A' and 'a' are treated as two different characters.
 *
 * Tip: HashMap + PriorityQueue.
 *
 * */

class Solution {
    // HashMap + PriorityQueue
    public String frequencySort(String s) { 
        if(s.length() == 0) return "";
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Character> pq= new PriorityQueue<>(
            (a, b) -> (count.get(b) - count.get(a)));
        for(Map.Entry<Character,Integer> m: count.entrySet()){
            pq.add(m.getKey());
        }
        StringBuilder res=new StringBuilder();
        while(pq.size()>0) {
            char ch=pq.poll();
            int freq= count.get(ch);
            for(int i=0;i<freq;i++) {
                res.append(ch);
            }    
        }
        return res.toString();
    }
    
    //Create a class + Arraylist sort
    class CharFreq {
        char c;
        int freq;
        public CharFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public String frequencySort2(String s) {
        char[] cnt = new char[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        List<CharFreq> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            list.add(new CharFreq((char) i, cnt[i]));
        }
        list.sort((a, b) -> b.freq - a.freq);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).freq; j++) {
                ans.append(list.get(i).c);
            }
        }
        return ans.toString();
    }
}