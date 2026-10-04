
class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    int m = num1.length();
    int n = num2.length();
    int[] result = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      int a = num1.charAt(i) - '0';
      for (int j = n - 1; j >= 0; j--) {
        int b = num2.charAt(j) - '0';
        int position = i + j + 1;
        result[position] += a * b;
      }
    }

    for (int position = result.length - 1; position > 0; position--) {
      result[position - 1] += result[position] / 10;

      result[position] %= 10;
    }

    int start = 0;
    while (start < result.length && result[start] == 0) {
      start++;
    }
    StringBuilder answer = new StringBuilder();
    for (int i = start; i < result.length; i++) {
      answer.append(result[i]);
    }
    return answer.toString();
  }
}
