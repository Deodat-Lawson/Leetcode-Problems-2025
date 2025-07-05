package org.example;

import java.io.*;
import java.util.*;

public class Amazon_RotateArray {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {

  }
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    int[] newArr = new int[nums.length];
    for(int i = 0; i + k < nums.length; i++){
      newArr[i + k] = nums[i];
    }

    for (int i = nums.length - k; i < nums.length; i++){
      newArr[i - nums.length + k] = nums[i];
    }

    for (int i = 0; i < nums.length; i++){
      nums[i] = newArr[i];
    }
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
