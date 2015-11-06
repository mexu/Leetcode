package leet;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	
	List<List<String>> res= new ArrayList<List<String>>();
	        
	    public List<List<String>> solveNQueens(int n) {
	        
	        if(n<=0) return res;
	        List<String> each = new ArrayList<String>();
	        int[] visited = new int[n];
	        for(int i=0;i<n;i++) visited[i]=-2;
	        dfs(each, 0, n, visited);
	        return res;
	    }  
	    
	    private void dfs(List<String> each, int row, int n, int[] visited){
	        if(each.size()==n) {
	            res.add(new ArrayList<String>(each));
	            return;
	        }
	        //for each row,recurse once.
	        // in each curse we could add diff position of q into char[] pos
	        //when add check if valid. then row++ into deeper curse 
	        for(int qcolumn=0; qcolumn<n; qcolumn++){
	            if(!isValid(qcolumn,row,visited)) continue;
	            else {
	                char[] lst=new char[n];
	                for(int x=0;x<n;x++) lst[x]='.';
	                lst[qcolumn]='Q';
	                each.add(String.valueOf(lst));
	                visited[row]=qcolumn;
	                dfs(each, row+1,n, visited);
	                visited[row]=-2;
	                each.remove(each.size()-1);
	            }
	        }
	    }
	    
	    private boolean isValid(int qcolumn, int row, int[] visited){
	        //check not in same row column blabla
	        for(int i=0;i<visited.length;i++){
	            if(Math.abs(i-row)<=1 && Math.abs(visited[i]-qcolumn)<=1) 
	                return false;
	            if(row==i && visited[i]!=-2) return false;
	            if(visited[i]==qcolumn) return false;
	            //if(Math.abs(i-row)==visited[i]-qcolumn)
	               // return false;
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen myqueen= new NQueen();
		int n=4;
		List<List<String>>t= myqueen.solveNQueens(n);
		System.out.println(t.size());
		
		for(int j=0;j<t.size();j++){
			for(int i=0;i<n;i++){
				//t.get(0).get(i);
				System.out.println(t.get(j).get(i));
			}
			System.out.println("next");
		}
		
	}

}
