package org.example;

import java.io.*;
import java.util.*;

public class Amazon_MaxFreqAfterSubarrayOperation {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int[] arr = {2, 8};
    int k = 8;
    System.out.println(maxFrequency(arr, k));
  }

  public static int maxFrequency(int[] nums, int k) {
    HashSet<Integer> possibleValues = new HashSet<>();
    int maxCount = 0;
    int originalCount = 0;
    for (int i = 0; i < nums.length; i++) {
      possibleValues.add(nums[i]);
      if(nums[i] == k){
        originalCount++;
      }
    }
    maxCount = originalCount;
    for (int num : possibleValues){
      if(num == k) continue;

      int[] psa = new int[nums.length];
      int maxDiff = 0;
      for(int i = 0; i < nums.length; i++){
        if(i >= 1){
          psa[i] = psa[i - 1];
        }
        else{
          psa[i] = 0;
        }
        if(nums[i] == num){
          psa[i]++;
        } else if(nums[i] == k){
          psa[i]--;
        }
      }

      int[] currentMinVal = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        if(i == 0){
          currentMinVal[i] = Math.min(psa[i], 0);
        } else {
          currentMinVal[i] = Math.min(currentMinVal[i - 1], psa[i]);
        }
        maxDiff = Math.max(maxDiff, psa[i] - currentMinVal[i]);
      }
      maxCount = Math.max(maxDiff + originalCount, maxCount);
    }
    return maxCount;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char nextCharacter() throws IOException {
    return next().charAt(0);
  }

  static String nextLine() throws IOException {
    return f.readLine().trim();
  }

}
