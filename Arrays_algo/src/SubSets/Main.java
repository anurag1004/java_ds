package SubSets;
import java.util.*;
public class Main {
    static void generateSubsets(int index, int[] nums, List<Integer> curr,List<List<Integer>> subsets){

        // copy the current list to subsets list
        subsets.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            generateSubsets(i+1,nums,curr,subsets);
            curr.remove(curr.size()-1); // backtrack
        }

    }
    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<Integer>(),subsets);
        return subsets;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums).toString());
    }
}
