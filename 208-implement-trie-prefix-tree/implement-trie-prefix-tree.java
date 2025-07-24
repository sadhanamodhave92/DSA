public class TrieNode {
     boolean isWord;
     TrieNode[] children;
    public TrieNode() {
        isWord = false;
        children= new TrieNode[26];
    }
}
class Trie {
    
    TrieNode root;
    public Trie() {
        root= new TrieNode();
    }
    
    public void insert(String word) {
        int n=word.length();

        TrieNode curr=root;
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isWord= true;
    }

    
    public boolean search(String word) {
        int n= word.length();
         TrieNode curr=root;
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null) return false;
            curr=curr.children[index];
        }
        return curr.isWord;

    }
    
    public boolean startsWith(String prefix) {
        int m = prefix.length();
        
        TrieNode curr = root;
        for (int i = 0 ; i < m ; i++) {
            int index = prefix.charAt(i) - 'a';
            
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
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