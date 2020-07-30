/**
 * This file contains an implementation of a Treap Class. Any comparable data
 * is allowed within this tree(numbers, strings, comparable Objects, etc...)
 * this is a max heap implementation(highest priority at top)
 * Supported operations include:
 * insert(x)
 * remove(x)
 * contains(x)
 *
 * @author JZ Chang, jzisheng@gmail.com
 */

package com.williamfiset.algorithms.datastructures.balancedtree;

import com.williamfiset.algorithms.datastructures.utils.TreePrinter;

import java.util.Random;
import java.awt.*;
public class TreapTree<T extends Comparable<T>> {

    static final int MAX_RAND_NUM = 100;

    private Random random;

    public class Node  implements TreePrinter.PrintableNode  {


        // The value/data contained within the node
        public T value;

        // The int priority of this node for Treap
        public int priority;

        // The left and right references of this node
        public Node left, right;

        public Node(T value, int priority) {
            this.value = value;
            this.priority = random.nextInt(100);
            this.left = this.right = null;
            this.priority = priority;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
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
    // The root node of the Treap tree.
    public Node root;

    // Tracks the number of nodes inside the tree
    private int nodeCount = 0;

    public TreapTree() {
        random = new Random();
    }

    // returns the number of nodes in the tree
    public int size(){
        return this.nodeCount;
    }

    public boolean contains(T value){
        return contains(root, value);
    }

    private boolean contains(Node node, T value) {
        if (node == null || value == null) return false;

        int cmp = value.compareTo(node.getValue());

        if (cmp < 0) return contains(node.left, value);

        else if (cmp > 0) return contains(node.right, value);

        else return true;
    }

    public boolean isEmpty(){
        return (nodeCount == 0);
    }

    public boolean insert(T val, int priority){
        if (val == null){
            throw new IllegalArgumentException("TreapTree does not allow null values");
        }
        if(!contains(root, val)) {
            root = insert(this.root, val, priority);
            nodeCount++;
            return true;
        }
        return false;
    }

    public boolean insert(T val){
        return insert(val, random.nextInt(MAX_RAND_NUM));
    }

    private Node insert(Node node, T value, int priority) {
        // base case
        if (node == null) { return new Node(value, priority); }

        // compare curr val to the val in the node
        int compareResult = value.compareTo(node.value);

        if (compareResult < 0){
            node.left = insert(node.left, value, priority);
            if (node.left.priority > node.priority){
                // right rotation
                node = rightRotation(node);
            }
        }
        else if (compareResult > 0){
            node.right = insert(node.right, value, priority);
            if (node.right.priority > node.priority){
                // left rotation
                node = leftRotation(node);
            }
        }
        // is duplicate, return nothing
        return node;
    }

    private Node leftRotation(Node node){
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        return newParent;
    }


    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        return newParent;
    }

    public void remove(T elem){
        root = remove(root, elem);
    }

    public Node remove(Node node, T elem){
        if (node == null) {
            return node;
        }
        int cmp = elem.compareTo(node.value);
    }

}
