class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int firstArrayLength = nums1.length, secondArrayLength = nums2.length;
        if(firstArrayLength > secondArrayLength) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalElements = (firstArrayLength + secondArrayLength);
        int numberOfElementsToBeConsidered = (firstArrayLength + secondArrayLength + 1) / 2;
        int low = 0, high = firstArrayLength;
        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = numberOfElementsToBeConsidered - mid1;
            int l1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < firstArrayLength ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < secondArrayLength ? nums2[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1) {
                if(totalElements % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
