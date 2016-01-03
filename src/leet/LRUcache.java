package leet;

import java.util.HashMap;

public class LRUcache {
	
	//Considering the item in cache is randomly picked despite of the order of entering the cache
	//Double linked list is easy to insert or delete and is more flexible, complexity is O(1);
    class DLLNode{
    	int key;
    	int value;
    	private DLLNode pre;
    	private DLLNode post;
    	public DLLNode(int key,int value){
    		this.key=key;
    		this.value=value;
    	}
    }
	//To reduce the time to find the cache item in the list, we can use HashMap, O(1);
    private HashMap<Integer,DLLNode> cachemap = new HashMap<Integer,DLLNode>();
    private int capacity;
    private int len;
    private DLLNode head;
    private DLLNode end;
	
	public LRUcache(int capacity) {
		this.capacity=capacity;
        len=0;
    }
    
    public int get(int key) {
    	
    	if(cachemap.containsKey(key)){
    		//delete from origin position
    		DLLNode node=cachemap.get(key);
    		deleteNode(node);
    		sethead(node);   		
    		return node.value;
    	}
        return -1;
    }
    //head and end is only a pointer. do not set it as a dummy!
    private void deleteNode(DLLNode node){
    	if(node.pre==null){
    		DLLNode post=node.post;
    		if(post!=null){
    	    	post.pre=null;
    	    	head=post;
    	    	//re-set head if old head is deleted!
    		}else head=null;
    	}else {
    		DLLNode pre=node.pre;
    		DLLNode post=node.post;
    		if(post!=null){
    			pre.post=post;
    			post.pre=pre;
    		}else{
    			pre.post=null;
    			end=pre;
    			//re-set end if old end is deleted!
    		}
    	}
    }
    
    public void set(int key, int value) {
    	if(!cachemap.containsKey(key)){
    		//insert
    		if(len==capacity){
    			//when full, remove from hashmap and also the linkedlist end node
    			cachemap.remove(end.key);
    			end=end.pre;
    			end.post=null;
    		}
    		DLLNode node=new DLLNode(key,value);
    		cachemap.put(key, node);
    		sethead(node);
    	} else{
    		//when the key exist,you still need to update!
    		//update so need to delet original position and set to head
    		DLLNode node=new DLLNode(key,value);
    		deleteNode(cachemap.get(key));
    		cachemap.put(key, node);
    		sethead(node);
    	}
    }
    
    public void sethead(DLLNode node){
    	node.post=head;
    	node.pre=null;
    	//when list is empty you gotta need to set head and end
    	if(head!=null){
    	    head.pre=node;
    	}
    	if(end==null){
    	    end=node;
    	}
		head=node;
    }
    
    
}
