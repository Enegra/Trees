package com.company;

import java.util.ArrayList;
import java.util.Collections;

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
        int parentIndex = (heapElements.indexOf(child) + 1) / 2 - 1;
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
            if (removedElement != null) {
                int removedIndex = heapElements.indexOf(removedElement);
                Node parent = getParent(removedElement);
                remove(root, root, data);
                if (removedElement.getLeftChild() != null && removedElement.getRightChild() != null) {
                    if (parent != null) {
                        int successorIndex;
                        if (isLeftChild(removedIndex)) {
                            successorIndex = heapElements.indexOf(parent.getLeftChild());
                            heapElements.set(removedIndex, heapElements.get(successorIndex));
                            heapElements.remove(successorIndex);
                        } else {
                            successorIndex = heapElements.indexOf(parent.getRightChild());
                            heapElements.set(removedIndex, heapElements.get(successorIndex));
                            heapElements.remove(successorIndex);
                        }
                    } else {
                        int successorIndex = heapElements.indexOf(root);
                        //although if it's root then index is just 0...
                        heapElements.set(removedIndex, heapElements.get(successorIndex));
                        heapElements.remove(successorIndex);
                    }
                    heapElements.remove(removedElement);
                    Node successor = heapElements.get(removedIndex);
                    while (canSink(successor)) {
                        sinkDown(successor, successor.getLeftChild(), successor.getRightChild());
                    }
                }

            }
        }
    }

    //Checks if given node can be used for sinkDown
    private boolean canSink(Node node) {
        return (node.getLeftChild() != null && !isBalanced(node.getLeftChild(),node)||(node.getRightChild() != null) &&!isBalanced(node.getRightChild(),node));
    }

    private void sinkDown(Node node, Node leftChild, Node rightChild) {
        if(node.getData() > leftChild.getData()){
            swap(node, leftChild);
        } else {
            swap(node, rightChild);
        }
    }

    private void swap(Node one, Node two){
        int indexOne = heapElements.indexOf(one);
        int indexTwo = heapElements.indexOf(two);
        swapNodes(one, two);
        heapElements.set(indexOne, two);
        heapElements.set(indexTwo, one);
        fixIncompleteNodes(two, one);
    }

    private void swapNodes(Node parent, Node child){
        //replacing nodes in the tree
        Node grandParent = getParent(parent);
        Node leftGrandChild = child.getLeftChild();
        Node rightGrandChild = child.getRightChild();
        if (parent!=root){
            if (grandParent.getLeftChild() == parent){
                grandParent.setLeftChild(child);
            }
            else {
                grandParent.setRightChild(child);
            }
        }
        else {
            root = child;
        }
        if(parent.getLeftChild() == child) {
            child.setLeftChild(parent);
            child.setRightChild(parent.getRightChild());
        } else {
            child.setLeftChild(parent.getLeftChild());
            child.setRightChild(parent);
        }
        parent.setLeftChild(leftGrandChild);
        parent.setRightChild(rightGrandChild);
    }

    private boolean isLeftChild(int index){
        return (index + 1) % 2 == 0;
    }

}
