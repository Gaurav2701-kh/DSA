class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n+1))/2;
        int a = 0;
        for(int i=0; i<n; i++){
            a += nums[i];
        }
        return (sum-a);
    }
}