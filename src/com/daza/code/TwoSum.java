package com.daza.code;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  //  This solution has a time complexity of O(n2). [Ou, en scuer].  It's not a good algorithm.
  public int[] process1(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  //  This solution has a time complexity of O(n). Because only iterates once in the array.
  public int[] process2(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int delta = target - nums[i];
      if (numMap.containsKey(delta)) {
        return new int[]{i, numMap.get(delta)};
      }
      numMap.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }
}
