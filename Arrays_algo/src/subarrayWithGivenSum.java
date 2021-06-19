import java.util.*;
public class subarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int i = 0;
        int j = 0;
        // window sliding
        // flxible window
        // target window sum = s
        int winSum = 0;
        while(i<n){
            while(j<n && winSum < s){
                winSum += arr[j];
                j++;
            }
            if(winSum==s){
                return new ArrayList<Integer>(Arrays.asList(i+1, j));
            }
            // contract window
            winSum -= arr[i];
            i++;
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
    public static void main(String[] args) {
        // given n non-negative numbers
        // we've to find sub Array with a given sum
        // 1st approach hashMap using prefix sum
        // 2nd -> 2 pointer approach
        //     -> Since prefix sum of positive elements is always positive and increasing
        //     -> Use a flexible sliding window
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k = 15;
        System.out.println(subarraySum(arr, arr.length, k));
    }
}
