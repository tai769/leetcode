class Solution{
  public int[][] merge(int[][] intervals){
    //1. 先把这个集合按照第一个元素排序出来
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<>();
    result.add[intervals[0]];
    for(int i = 1 ; i < intervals.length; i++){
      int[] curr = intervals[i];
      int[] last = result.get(result.size() - 1);
      if(curr[0] <= last[1]){
        last[1] = Math.max(last[1], curr[1]);
      }else{
        result.add(curr);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
