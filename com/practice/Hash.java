package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hash<K, V> {
   private class Node {
      K key;
      V value;

      public Node(K key, V value) {
         this.key = key;
         this.value = value;
      }

      @Override
      public String toString() {
         return "Node{" +
                 "key=" + key +
                 ", value=" + value +
                 '}';
      }
   }

   private LinkedList<Node>[] table;
   private int size = 0;
   private final double loadingFactor = 0.75;
   private int tableLength = 16;

   public Hash() {
      initializeBucket(tableLength);
      size = 0;
   }

   private void initializeBucket(int len) {
      table = new LinkedList[len];
      for (int i = 0; i < len; i++) {
         table[i] = new LinkedList<>();
      }
   }

   public void put(K key, V value) {
      int hashIndex = hashFunction(key);
      int indexInTable = indexFunction(key, hashIndex);
      if (indexInTable != -1) {
         Node node = table[hashIndex].get(indexInTable);
         node.value = value;
      } else {
         Node node = new Node(key, value);
         table[hashIndex].add(node);
         size++;
      }
      // checking thrash hold value
      double lambda = size * 1.0 / table.length;
      if (lambda > 0.75) {
         rehashing();
      }
   }

   private void rehashing() {
//      System.out.println("rehashing occur");
      LinkedList<Node>[] tempTable = table;
      table = null;
      initializeBucket(tableLength * 2);
      tableLength *= 2;
      size = 0;
      for (LinkedList<Node> nodes : tempTable) {
         for (Node node : nodes) {
            put(node.key, node.value);
         }
      }
   }

   public V get(K key) {
      int tableIndex = hashFunction(key);
      int indexIfAvailable = indexFunction(key, tableIndex);
      return indexIfAvailable != -1 ? table[tableIndex].get(indexIfAvailable).value : null;
   }

   public boolean containsKey(K key) {
      int tableIndex = hashFunction(key);
      int indexIfAvailable = indexFunction(key, tableIndex);
      return indexIfAvailable != -1;
   }

   public List<K> keySet() {
      List<K> keys = new ArrayList<>();
      for (LinkedList<Node> eachTable : table) {
         for (Node node : eachTable) {
            keys.add(node.key);
         }
      }
      return keys;
   }

   public K remove(K key) {
      int tableIndex = hashFunction(key);
      int indexIfAvailable = indexFunction(key, tableIndex);
      if (indexIfAvailable != -1) {
         Node node = table[tableIndex].remove(indexIfAvailable);
         return node.key;
      } else {
         return null;
      }
   }

   public int size() {
      return size;
   }

   private int indexFunction(K key, int hashIndex) {
      LinkedList<Node> tableData = table[hashIndex];
      int atIndex = 0;
      for (Node node : tableData) {
         if (node.key.equals(key)) {
            return atIndex;
         }
         atIndex++;
      }
      return -1;
   }

   private int hashFunction(K key) {
      return Math.abs(key.hashCode()) % table.length;
   }

   public void print() {
      for (LinkedList list : table) {
         System.out.println(Arrays.toString(list.toArray()));
      }
   }
}
