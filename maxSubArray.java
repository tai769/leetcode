class Solution {

  public int maxSubArray(int[] nums) {
    // 滑动窗口
    int currSum = nums[0];
    int maxSum = nums[0];
    for (int r = 1; r < nums.length; r++) {
      // 1. 滑动窗口
      if (currSum < 0) {
        currSum = nums[r];
      } else {
        currSum += nums[r];
      }

      if (currSum > maxSum) {
        maxSum = currSum;
      }
    }
    return maxSum;
  }

}
