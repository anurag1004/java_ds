package firstLastOccurence;
//Find First and Last Position of Element in Sorted Array
public class Main {
    // will find the first occurence of target on the left side
    static int firstOccurence(int[] nums,int low,int high,int target){
        int first = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                first = mid;
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return first;
    }
    // will find the last occurence of target on the right side
    static int lastOccurence(int[] nums,int low,int high,int target){
        int last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                last = mid;
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return last;
    }
    static int[] findFirstLastOccurence(int[] nums,int target){
        return new int[]{firstOccurence(nums,0,nums.length-1,target),lastOccurence(nums,0,nums.length-1,target)};
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,4,4,4,5,6,7,7,7,8,9};
        int[] result = new int[2];
        int target = 4;
        result  = findFirstLastOccurence(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}
