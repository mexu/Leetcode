package leet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res= new ArrayList<String>();
		if(words==null) return res;
		int i=0;
		while(i<words.length){
			Entry e=getText(words,maxWidth,i);
			res.add(e.str);
			i+=e.num;
		}
		
		return res;
    }
	class Entry{
		int num;
		String str;
		Entry(int num, String str){
			this.num=num;
			this.str=str;
		}
	}
	
	public Entry getText(String[] words, int maxWidth, int start){
		StringBuilder str=new StringBuilder();
		//count how many word will fit in
		int cnt=0;
		int textlen=0;
		int pre=start;
		while(start<words.length){
			if(cnt+words[start].length()>maxWidth) break;
			cnt+=words[start].length();
			textlen+=words[start].length();
			start++;
			cnt++;
		}
		if(start==words.length){
			for(int i=pre;i<start;i++){
				str.append(words[i]);
				if(i!=start) str.append(" ");
			}
		}else if(start-pre==1){
			str.append(words[start-1]);
			for(int m=0;m<maxWidth-textlen;m++) str.append(" ");
		}else{
			//calculate if the space even/odd
			int addone=(maxWidth-textlen)%(start-pre-1);
			int spacenum=(maxWidth-textlen)/(start-pre-1);
			//append word to str, mind the space, mind if only one word
			for(int j=pre;j<start;j++){
				if(j==pre) str.append(words[j]);
				else{
					if(addone>0){
						for(int m=0;m<spacenum+1;m++) str.append(" ");
						addone--;
					}else
						for(int m=0;m<spacenum;m++) str.append(" ");
					str.append(words[j]);
				}
			}
		}
		
		return new Entry(start-pre,str.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubS
		TextJustification mytest=new TextJustification();
		String[] words={"What","must","be","shall","be."};
		String[] words2={"This", "is", "an", "example", "of", "text", "justification."};
		//Entry str=mytest.getText(words, 16, 0);
		//System.out.println(str.str);
		//System.out.println(str.num);
		Iterator i=mytest.fullJustify(words, 16).iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
