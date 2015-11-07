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
            root=new TrieNode();
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
        
        public boolean search(String words){
            TrieNode node= this.root;
            for(char c:words.toCharArray()){
                if(node.children[c-'a']==null){
                	return false;
                }else{
                    node=node.children[c-'a'];
                }
            }
            if(node.end==true) return true;
            else return false;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res= new ArrayList<String>();
        Trie trietree= new Trie();
        //build trie tree
        for(int i=0;i<words.length;i++){
        	trietree.add(words[i]);
        }
        StringBuilder str=new StringBuilder();
        boolean[][] visited= new boolean[board.length][board[0].length];
        //dfs check if certain path from board[row][col] is in trie tree
        for(int row=0;row<board.length;row++){
        	for(int col=0;col<board[0].length;col++){
        		
        		dfs(board,trietree,str,visited,row,col);
        	}
        }
        return res;
    }
    
    private boolean dfs(char[][] board, Trie trietree, StringBuilder str,boolean[][] visited, int row, int col){
    	return false;
    }
}
