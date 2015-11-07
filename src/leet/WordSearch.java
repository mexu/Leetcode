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
        
        public boolean startWith(String words){
        	TrieNode node= this.root;
            for(char c:words.toCharArray()){
                if(node.children[c-'a']==null){
                	return false;
                }else{
                    node=node.children[c-'a'];
                }
            }
            return true;
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
        		
        		dfs(res,board,trietree,str,visited,row,col);
        	}
        }
        return res;
    }
    
    private boolean inboundry(int rlen,int clen,int rol, int col){
    	if(rol<rlen && rol>=0 && col<clen && col>=0) return true;
    	else return false;
    }
    
    private void dfs(List<String> res, char[][] board, Trie trietree, StringBuilder str,boolean[][] visited, int row, int col){
    	//debug index range boundry!
    	if(trietree.search(str.toString())){
    		res.add(str.toString());
    	}
    	
    	if(inboundry(board.length,board[0].length,row,col) && !visited[row][col] && trietree.startWith(str.toString())){
    		visited[row][col]=true;
    		str.append(board[row][col]);
    		dfs(res,board,trietree,str,visited,row+1,col);
    		dfs(res,board,trietree,str,visited,row-1,col);
    		dfs(res,board,trietree,str,visited,row,col+1);
    		dfs(res,board,trietree,str,visited,row,col-1);
    		visited[row][col]=false;
    		str.deleteCharAt(str.length()-1);
    	}
    	
    	return;
    }
}
