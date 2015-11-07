package leet;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	

	class TrieNode{
        public TrieNode[] children=new TrieNode[26];
        boolean end;
        
        public TrieNode(){ }
    }
	
    class Trie{
    	public TrieNode root;
        public Trie(){
            TrieNode root=new TrieNode();
        }
        
        private void add(String words){
            TrieNode node=root;
            for(char c:words.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                    node=node.children[c-'a'];
                }else{
                    node=node.children[c-'a'];
                }
            }
            node.end=true;
        }
        
        public void search(String words){
            TrieNode node= this.root;
            for(char c:words.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                    node=node.children[c-'a'];
                }else{
                    node=node.children[c-'a'];
                }
            }
            node.end=true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res= new ArrayList<String>();
        return res;
    }
}
