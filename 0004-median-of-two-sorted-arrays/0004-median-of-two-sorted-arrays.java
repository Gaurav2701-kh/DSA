class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary-search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            // Partition nums1
            int partition1 = (left + right) / 2;

            // Partition nums2 so that left side has half the elements
            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int minRight1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int maxLeft2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int minRight2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }

                // Even total length
                return (Math.max(maxLeft1, maxLeft2)
                        + Math.min(minRight1, minRight2)) / 2.0;
            }

            // We have taken too many elements from nums1
            if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }
            // We need to take more elements from nums1
            else {
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
