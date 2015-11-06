package leet;

public class WordDictionary {
    
	public int[] vallist;
    public WordDictionary[] diclst;
    
    public WordDictionary(){
        vallist=new int[26];
        diclst=new WordDictionary[26];
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        WordDictionary cur=this;
        for(int i=0;i<word.length();i++){
        	System.out.println("asd");
            if(cur.vallist!=null && cur.vallist[word.charAt(i)-'a']!=0){
                cur=cur.diclst[word.charAt(i)-'a'];  
            }else{
            	System.out.println("addd");
                cur.vallist[word.charAt(i)-'a']=1;
                cur.diclst[word.charAt(i)-'a']=new WordDictionary();///debug?
                cur=cur.diclst[word.charAt(i)-'a'];
            }
        }
    }
    
    public boolean search(String word) {
        if(word.length()==0|| word==null) return true;
        WordDictionary dic=this;
        return dfs(word,0,dic);
    }
    
    public boolean dfs(String word,int index,WordDictionary dic){
        //word is longer than dictionary then null pointer. be careful!
    	//if(dic.vallist)
    	if(dic==null && index<word.length()) return false;
        if(index==word.length()) return true;
        
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                if(dic.vallist[i]!=0){
                    return dfs(word,index+1,dic.diclst[i]);
                }
            }
            return false;
        }else{
            if(dic.vallist[word.charAt(index)-'a']!=0){
                return dfs(word,index+1,dic.diclst[word.charAt(index)-'a']);
            }else return false;
        }
    }
    
    public static void main(String[] args) {
    	WordDictionary t=new WordDictionary();
    	t.addWord("bad");
    	//System.out.println(t.vallist['b'-'a']);
    	System.out.println(t.diclst['b'-'a'].diclst[0]);
    	t.addWord("ran");
    	t.addWord("rune");
    	t.addWord("runner");
    	t.addWord("runs");
    	t.addWord("add");
    	t.addWord("adds");
    	t.addWord("runs");
    	t.addWord("add");
    	t.addWord("adder");
    	t.addWord("addee");
    	
    	System.out.println("a");
    	System.out.println(t.search("r.n"));
    	System.out.println("b");
    	System.out.println(t.search("bad"));
    	System.out.println("c");
    	System.out.println(t.search("ru.n.e"));
    	System.out.println("d");
    	System.out.println(t.search("add"));
    	System.out.println("a");
    	System.out.println(t.search("add."));
    	System.out.println("a");
    	System.out.println(t.search(".an."));//////////null pointer
    	System.out.println("a");
    	System.out.println(t.search("...s"));
    	System.out.println("a");
    	System.out.println(t.search("....e."));
    	System.out.println("a");
    	//,,,,,,,search("adde."),,,,search("......."),search("..n.r")
    	//*/
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");