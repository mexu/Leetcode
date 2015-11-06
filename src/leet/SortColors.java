package leet;
import java.util.ArrayList;

public class SortColors {
	public void sortColors(int[] nums) {
        if(nums==null || nums.length==0)  
       return;  
       
   int[] res = new int[nums.length];  
   int[] helper = new int[3];
   
   for(int i=0;i<nums.length;i++)  
   {  
       helper[nums[i]]++; } 
   ///////
   for(int item:helper){
		System.out.println(item);
	}
   
   for(int i=1;i<3;i++)  
   {  
       helper[i]=helper[i]+helper[i-1];  
   }  
   //
   for(int item:helper){
		System.out.println(item+"after");
	}
   //
   for(int i=nums.length-1;i>=0;i--)  
   {  
       res[helper[nums[i]]-1] = nums[i];  
       
   		System.out.println(helper[nums[i]]-1+",,");
   	
       helper[nums[i]]--;  
   }  
   for(int i=0;i<nums.length;i++)  
   {  
       nums[i] = res[i];  
   }  
   }
	public static void main(String[] args) {
		SortColors tmp= new SortColors();
		int[] t={0,0,0,0,1,2,2,2,2,0,0,1};
		tmp.sortColors(t);
		for(int item:t){
		//	System.out.println(item);
		}
	}
}
