package leet;

public class MergeKLst {
	public class ListNode{
		ListNode next;
		int val;
		ListNode(int n){
			val=n;
			this.next=null;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length-1;
        if(lists.length==0||lists==null) return null;
        return divideLst(lists,0,len);
    }
    
    public ListNode divideLst(ListNode[] lists,int start, int end){
        if(start<end){
            ListNode node1=divideLst(lists,start,(start+end)/2);
            ListNode node2=divideLst(lists,(start+end)/2+1,end);
            return merge(node1,node2);
        }
        return lists[start];
    }
    
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode start=new ListNode(-3);
        ListNode pre=start;
        
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                start.next=node1;
                start=node1;
                node1=node1.next;
            }else{
                start.next=node2;
                
                start=node2;
                node2=node2.next;
            }
        }
        
        if(node1!=null) start.next=node1;
        else start.next=node2;
        
        return pre.next;
    }
}
