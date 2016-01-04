package leet;

public class Sqrt {
	
	public int mySqrt(int x) {
        if(x==0) return 0;
        //can not divide by zero
        int low=1;
        //start from 1
        int high=x;
        while(low<high){
            int mid=(low+high)/2;
            if(mid<=x/mid && mid+1>x/(mid+1)) return mid;
            //this is how we check if mid is square root of x, mind <=
            else if(mid>x/mid) high=mid;
            else low=mid+1;
        }
        return low;
    }

}
