class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();

    int bestLeft = 0;
    int bestRTight = 0;
    int bestLength = 1;
    boolean[][] dp = new boolean[n][n];
    for (int length = 1; length <= n; length++) {
      for (int left = 0; left + length <= n; left++) {
        int right = left + length - 1;
        dp[left][right] = s.charAt(left) == s.charAt(right) &&
            (length <= 2 || dp[left + 1][right - 1]);

        if (dp[left][right]) {
          if (length > bestLength) {
            bestLength = length;
            bestLeft = left;
            bestRTight = right;
          }
        }
      }
    }
    return s.substring(bestLeft, bestRTight + 1);

  }
}
