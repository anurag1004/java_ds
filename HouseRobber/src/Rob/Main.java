package Rob;
// using dfs
public class Main {
    static int global_max = 0;
    static void getMaxLoot(int[] nums, int index, int curr_sum){
        curr_sum += nums[index];
        global_max = Math.max(curr_sum, global_max);
        for(int i=index+2;i<nums.length;i++){
            getMaxLoot(nums, i, curr_sum);
        }
    }
    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        for(int i=0;i<nums.length;i++){
            getMaxLoot(nums, i, 0);
        }
        System.out.println(global_max);
    }
}
