class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> num = new ArrayList<>();

        int idx = 0;
        Arrays.sort(nums);
        f(nums, ans, num, idx);
        
        
        return ans; 
    }
        public static void f(int[] nums, List<List<Integer>> ans, List<Integer> num, int idx) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(num)); 
            return;
        }
        num.add(nums[idx]);
        f(nums, ans, num, idx + 1);
        
        num.remove(num.size() - 1);
        int nxt = idx + 1;
        while(nxt<nums.length && nums[idx] == nums[nxt]){
            nxt++;
        }
        f(nums, ans, num, nxt);
    }
}