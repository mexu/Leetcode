package leet;

public class Duplilcate {
	public int removeDuplicates(int[] nums) {
		//duplicates are allowed at most twice
        int len=nums.length;
        if(len<3) return len;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==pre){
            	//System.out.println(pre+"pre"+i);
                int j=i;
                while(j+1<nums.length && nums[j+1]==nums[j]){
                    len--;
                    //System.out.println(j+1+"aaa"+len);
                    j++;
                }
                //if 2,2,2,2 then the last one wont be reached
                if(j+1<nums.length){pre=nums[j+1];}
                i=j+1;
                //System.out.println(i+"i");
            }else{
            	pre=nums[i];
            }
        }
        return len;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duplilcate t =new Duplilcate();
		int[] nums={1,1,1,2,2,3,3,3};
		//t.removeDuplicates(nums);
		System.out.println(t.removeDuplicates(nums));
	}

}
