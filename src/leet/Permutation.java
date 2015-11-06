package leet;

import java.util.Arrays;

public class Permutation {
	
	public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>=0;i--){
            Arrays.sort(nums,i,nums.length);
            for(int n=0;n<nums.length;n++){
    			System.out.println(nums[n]+"aa");
    		}
            for(int j=i;j<nums.length;j++){
            	System.out.println(nums[j]+"bb>"+nums[i-1]);
                if(j>0 && nums[j]>nums[i-1]){
                    int tmp=nums[j];
                    nums[j]=nums[i-1];
                    nums[i-1]=tmp;
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation test= new Permutation();
		int[] nums={4,5,1};
		test.nextPermutation(nums);
		//Arrays.sort(nums,1,3);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		
	}

}
