/**
 * Day 13 - Remove K Digits
 * 
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 *  The length of num is less than 10002 and will be ≥ k.
 *  The given num does not contain any leading zero.
 * 
 * Example 1: 
 *  Input: num = "1432219", k = 3 
 *  Output: "1219"
 *  Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2: 
 *  Input: num = "10200", k = 1 
 *  Output: "200"
 *  Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3: 
 *  Input: num = "10", k = 2 
 *  Output: "0"
 *  Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * Tip: Greedy
*/

class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        if(num.length() == k) return "0";  
          
        int newLength = num.length()-k;
        char[] stack = new char[num.length()];
        int top=-1;
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(top >=0 && stack[top] > c && k > 0){
                top--;
                k--;
            }
            stack[++top] = c;
        }        
        int start=0;
        while(start < newLength && stack[start] == '0'){
            start++;
        }        
        return start == newLength ? "0" : new String(stack, start, newLength-start);
    }
    
    public String removeKdigits1(String num, int k) {
        if(k==0) return num;
        if(num.length() == k) return "0";  

        int remove = 0;        
        Stack<Character> stack = new Stack<>();        
        for(int index = 0; index < num.length(); index++ ){
            char c = num.charAt(index);
            while(!stack.isEmpty() && remove < k && stack.peek() > c){
                stack.pop();
                remove++;
            }            
            stack.push(c);
        }        
        while(remove < k){
            stack.pop();
            remove++;
        }        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }        
        while(res.length() > 1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();
    } 
}