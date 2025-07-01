package org.example;

import java.io.*;
import java.util.*;

public class Amazon_LRUCache {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public static class LRUCache {
    class Node {
      int key;
      int val;
      Node next;
      Node prev;

      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node last;

    public LRUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      Node currentKey = map.getOrDefault(key, null);
      if (currentKey == null) {
        return -1;
      }
      int returnValue = currentKey.val;
      if (currentKey != head) {
        if (currentKey == last) {
          last = currentKey.prev;
          currentKey.prev.next = null;
        } else {
          currentKey.prev.next = currentKey.next;
          currentKey.next.prev = currentKey.prev;
        }
        updateKey(currentKey);
      }
      return returnValue;
    }

    public void put(int key, int value) {
      Node currentKey = map.getOrDefault(key, null);
      if (currentKey == null) {
        Node newKey = new Node(key, value);
        updateKey(newKey);
        map.put(key, newKey);
        System.out.println("head " + head.key + " last " + last.key);
        if (map.size() > capacity) {
          int lastKey = last.key;
          last = last.prev;
          last.next = null;
          map.remove(lastKey);
        }
      } else {
        currentKey.val = value;
        if (currentKey != head) {
          if (currentKey == last) {
            System.out.println("is last");
            last = currentKey.prev;
            currentKey.prev.next = null;
          } else {
            currentKey.prev.next = currentKey.next;
            currentKey.next.prev = currentKey.prev;
          }
          updateKey(currentKey);
        }
        map.put(key, currentKey);
      }
    }

    public void updateKey(Node keyValPair) {
      if (head == null) {
        head = keyValPair;
        last = keyValPair;
        return;
      }
      keyValPair.next = head;
      keyValPair.prev = null;
      head.prev = keyValPair;
      head = keyValPair;
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
