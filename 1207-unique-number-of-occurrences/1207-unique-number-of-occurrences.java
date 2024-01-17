class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    var map = new HashMap<Integer, Integer>();
    
    for (var num : arr)
      map.put(num, map.getOrDefault(num, 0) + 1);
    
    var set = new HashSet<Integer>();
    
    for (var val : map.values())
      if (set.contains(val)) return false;
      else set.add(val);
    
    return true;
  }
}