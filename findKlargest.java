import java.util.Scanner;

import com.sun.tools.javac.Main;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    int target = nums.length - k;
    int left = 0;
    int right = nums.length - 1;
    if (left == right) {

      return nums[target];
    }

    while (left < right) {
      int pivot = nums[left];

      int i = left;
      int j = right;
      while (true) {
        while (nums[i] < pivot) {
          i++;
        }
        while (nums[j] > pivot) {
          j--;
        }
        if (i >= j) {
          break;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        i++;
        j--;
      }
      if (target <= j) {
        right = j;
      } else {
        left = j + 1;
      }

    }
    return nums[left];

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution solution = new Solution();
    System.out.println(solution.findKthLargest(nums, k));
  }
}
