package com.williamfiset.algorithms.datastructures.balancedtree;

import com.williamfiset.algorithms.datastructures.utils.TreePrinter;

import java.util.Map;

public class BTree<T extends Comparable<T>> {
  // static M children
  private static final int M = 4;

  public class Node implements TreePrinter.PrintableNode {
    private int M; // number of children
    public T value;
    public Map.Entry[] children = new Map.Entry[M];

    public Node left, right;

    public Node(T value){
      this.value = value;
      this.left = this.right = null;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
      return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
      return right;
    }

    @Override
    public String getText() {
      return value.toString();
    }
  }
  private Node root;
  private int height;
  private int n; // number of key value pairs

  public BTree(){
    root = new Node(null);
  }

  public boolean insert(T val){
    if (val == null){
      throw new IllegalArgumentException("BTree does not allow null values");
    }
    return true;
  }
}
