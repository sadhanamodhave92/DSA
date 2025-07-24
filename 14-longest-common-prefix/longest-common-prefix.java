
class Solution {
    public class TrieNode {
     boolean isWord;
     TrieNode[] children;
     int freq;
        public TrieNode() {
            isWord = false;
            children= new TrieNode[26];
            freq=1;
        }
    }
     TrieNode root = new TrieNode();
   
    
    public void insert(String word) {
        int n=word.length();

        TrieNode curr=root;
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            } else{
                curr.children[index].freq++;
            }
            curr=curr.children[index];
        }
        curr.isWord= true;
    }

    
    public String search(String word, int size) {
        int n= word.length();
         TrieNode curr=root;
         int count=0;
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index].freq==size) {
                count++;
            } else {
                break;
            }
            curr=curr.children[index];
        }
        return word.substring(0,count);

    }
    public String longestCommonPrefix(String[] strs) {
         for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
        return search(strs[0],strs.length);
    }
}