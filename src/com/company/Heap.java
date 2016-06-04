package com.company;

import java.util.ArrayList;

/**
 * Created by agnie on 6/2/2016.
 */
public class Heap extends BinaryTree {

    ArrayList<Node> heapElements;
    private boolean min;

    //the heap is a min-heap by default
    public Heap() {
        incompleteNodes = new ArrayList<Node>();
        heapElements = new ArrayList<Node>();
        min = true;
    }

    //constructor for a max-heap
    public Heap(boolean min) {
        incompleteNodes = new ArrayList<Node>();
        heapElements = new ArrayList<Node>();
        this.min = min;
    }

    @Override
    public void insert(int data) {
        if (!find(data)) {
            Node newNode = new Node(data);
            insert(newNode);
            heapElements.add(newNode);
            Node parent = getParent(newNode);
            while (parent != null && !isBalanced(newNode, parent)) {
                sort(newNode, parent);
                parent = getParent(newNode);
            }

        }
    }

    private void sort(Node node, Node parent) {
        //sets node as child of parent's parent if parent isn't root
        if (parent != root) {
            Node parentsParent = getParent(parent);
            if (parentsParent.getLeftChild() == parent) {
                parentsParent.setLeftChild(node);
            } else {
                parentsParent.setRightChild(node);
            }
        }
        //swaps around node and parent in binary tree and heapElements
        int parentIndex = heapElements.indexOf(parent);
        heapElements.set(heapElements.indexOf(node), parent);
        heapElements.set(parentIndex, node);
        Node leftChild = node.getLeftChild();
        Node rightChild = node.getRightChild();
        if (parent.getLeftChild() == node) {
            node.setLeftChild(parent);
            node.setRightChild(parent.getRightChild());
        } else {
            node.setRightChild(parent);
            node.setLeftChild(parent.getLeftChild());
        }
        parent.setLeftChild(leftChild);
        parent.setRightChild(rightChild);
        fixIncompleteNodes(node, parent);
        if (root == parent) {
            root = node;
        }
    }


    private Node getParent(Node child) {
        int parentIndex = (heapElements.indexOf(child) + 1) / 2 -1;
        if (parentIndex >= 0) {
            return heapElements.get(parentIndex);
        }
        return null;
    }

    //checking if the newly added node affects the structure of the heap
    private boolean isBalanced(Node node, Node parent) {
        return min && node.getData() > parent.getData() || !min && node.getData() < parent.getData();
    }

    private void fixIncompleteNodes(Node node, Node parent) {
        if (incompleteNodes.contains(node)) {
            int nodeIndex = incompleteNodes.indexOf(node);
            if (incompleteNodes.contains(parent)) {
                int parentIndex = incompleteNodes.indexOf(parent);
                incompleteNodes.set(parentIndex, node);
            }
            incompleteNodes.set(nodeIndex, parent);
        }
    }

    @Override
    public void remove(int data) {
            if (root == null) {
                System.out.println("The tree is empty");
            } else {
                Node removedElement = search(data);
                if (removedElement!=null) {
                    int removedIndex = heapElements.indexOf(removedElement);
                    Node parent = getParent(removedElement);
                    remove(root, root, data);
                    heapElements.remove(removedElement);
                    //TODO fix stuff - need to remove the removed element from the array, but first need to swap it with successor
                    //todo after that we need to shuffle the heap if the successor violated the structure
                    if (removedElement.getLeftChild()!=null&&removedElement.getRightChild()!=null){
                        if (parent!=null){
                            int successorIndex;
                            if ((removedIndex+1)%2==0){
                                successorIndex = heapElements.indexOf(parent.getLeftChild());
                            }
                            else {
                                successorIndex = heapElements.indexOf(parent.getRightChild());
                            }

                        }
                        else {
                            int successorIndex = heapElements.indexOf(root);
                            //although if it's root then index is just 0...
                        }
                    }
                }
            }
        }


}
