package org.example;

import java.io.*;
import java.util.*;

public class Amazon_MaxYSumByPickingTriplet {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public int maxSumDistinctTriplet(int[] x, int[] y) {
    ArrayList<Integer> topVal = new ArrayList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < x.length; i++) {
      int curr = map.getOrDefault(x[i], 0);
      curr = Math.max(curr, y[i]);
      map.put(x[i], curr);
    }
    if(map.size() < 3){
      return -1;
    }

    for(int key : map.keySet()){
      topVal.add(map.get(key));
    }
    Collections.sort(topVal);
    return topVal.get(topVal.size() - 1) + topVal.get(topVal.size() - 2) + topVal.get(topVal.size() - 3);
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
