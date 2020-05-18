package com.toy.data.structure;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = union(nums1, nums2);
        if( result == null || result.length == 0){
            return -1.0;
        }

        int length = result.length;
        if( length % 2 == 0){
            return (result[length/2] + result[length/2 - 1])/2.0;
        }else{
            return result[length/2];
        }

    }

    private int[] union(int[] nums1, int[] nums2){
        if((nums1 == null || nums1.length == 0) && nums2 != null){
            return nums2;
        }

        if((nums2 == null || nums2.length == 0) && nums1 != null){
            return nums1;
        }

        int[] nums3 = new int[nums1.length + nums2.length];
        boolean oneIsMax = nums1.length > nums2.length ? true : false;
        int maxLenght = oneIsMax ? nums1.length : nums2.length;
        int nums1Cur = 0;
        int nums2Cur = 0;
        int nums3Cur = 0;
        for(int cur = 0; cur < maxLenght ; ){
            if( nums1Cur < nums1.length && nums2Cur < nums2.length && nums1[nums1Cur] < nums2[nums2Cur]) {
                nums3[nums3Cur++] = nums1[nums1Cur++];
                if(oneIsMax){
                    cur++;
                }
                continue;
            }
            if( nums1Cur < nums1.length && nums2Cur < nums2.length && nums1[nums1Cur] >= nums2[nums2Cur] ){
                nums3[nums3Cur++] = nums2[nums2Cur++];
                if(!oneIsMax){
                    cur++;
                }
            }
        }

        while(nums1Cur < nums1.length){
            nums3[nums3Cur++] = nums1[nums1Cur++];
        }

        while(nums2Cur < nums2.length){
            nums3[nums3Cur++] = nums2[nums2Cur++];
        }
        return nums3;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
