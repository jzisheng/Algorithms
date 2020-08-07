package com.williamfiset.algorithms.datastructures.balancedtree;

import org.junit.Before;
import org.junit.Test;

public class BTreeTest {
  private BTree<Integer> tree;

  @Before
  public void setup(){
    tree = new BTree<>();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullInsertion(){
    tree.insert(null);
  }
}
