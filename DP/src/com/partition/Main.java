package com.partition;

import java.util.Arrays;

public class Main {
    // backtracking
    private static boolean canPartitionKSubsets(int loopIndex, int[] nums, int noOfBuckets,
                                                int currBucketSum, int targetBucketSum, boolean[] used)
    {
        if(noOfBuckets==1)
            return true;
        if(currBucketSum > targetBucketSum)
            return false;
        if(currBucketSum == targetBucketSum){
            // one bucket sum completed
            // k-1 buckets left
            return canPartitionKSubsets(0, nums, noOfBuckets-1, 0, targetBucketSum, used);
        }
        for(int i=loopIndex;i<nums.length;i++){
            // for skipping duplicates
            if( i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            if(!used[i]){
                used[i] = true;
                if(canPartitionKSubsets(i+1, nums, noOfBuckets, currBucketSum+nums[i], targetBucketSum, used))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x: nums) sum += x;
        if(sum%k!=0)
            return false;
        int targetBucketSum = sum/k;
        // k is the number of buckets
        return canPartitionKSubsets(0, nums, k, 0, targetBucketSum, new boolean[nums.length]);
    }

    public static void partitionEqualSumSubset(int[] arr){
        // partition equal subset sum
        int n = arr.length;
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        if(sum%2!=0){
            System.out.println("Can not be partitioned !");
            return;
        }
        int partSum = sum/2;
        System.out.println("Sum "+sum);
        System.out.println("EachPart Sum "+partSum);
        int[][] dp = new int[n+1][partSum+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=partSum;j++){
                if(j >= arr[i-1]){
                    int taken = arr[i-1] + dp[i-1][j-arr[i-1]];
                    int notTaken = dp[i-1][j];
                    dp[i][j] = Math.max(taken, notTaken);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=partSum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Can be partitioned int two equal subsets ? "+ (dp[n][partSum]==partSum));
    }
    public static int waysOfpartitionArray(int A, int[] B){
        int sum = 0;
        for(int x: B) sum += x;
        if(sum%3!=0)
            return 0;
        int count = 0;
        int partSum = sum/3;
        boolean[] suffix = new boolean[A];
        sum = 0;
        for(int i=A-1;i>=0;i--){
            sum += B[i];
            if(sum==partSum)
                suffix[i] = true;
        }
        sum = 0;
        for(int i=0;i<A;i++){
            sum += B[i];
            if(sum==partSum){
                for(int j=i+2;j<A;j++){
                    if(suffix[j])
                        count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int[] arr = {2,2,2,2,2,2,3,2,2,2,2,2,2,3,2};
//        partitionEqualSumSubset(arr);
        Arrays.sort(arr);
//        System.out.println(canPartitionKSubsets(arr, 8));
        System.out.println(waysOfpartitionArray(5, new int[]{1,2,3,0,3}));
    }
}
