package com.company;

import java.util.ArrayList;

/**
 * Created by agnie on 6/2/2016.
 */
public class Heap extends BinaryTree {

    ArrayList<Node> heapElements;

    public Heap(){
        incompleteNodes = new ArrayList<Node>();
        heapElements = new ArrayList<Node>();
    }

    @Override
    public void insert(int data) {
        if (!find(data)) {
            Node newNode = new Node(data);
            insert(newNode);
            heapElements.add(newNode);
            //todo function to place element on correct place
        }
    }

    private void sort(Node node) {
        Node parent = getParent(node);
        if(node.getData() < parent.getData()) {
            //sets node as children of parent's parent if parent isn't root
            if(parent != root) {
                Node parentsParent = getParent(parent);
                if(parentsParent.getLeftChild() == parent){
                    parentsParent.setLeftChild(node);
                } else {
                    parentsParent.setRightChild(node);
                }
            }
            //swaps around node and parent in binary tree and heapElements
            int temp = heapElements.indexOf(parent);
            if(parent.getLeftChild() == node) {
                heapElements.set(heapElements.indexOf(node), parent);
                heapElements.set(temp, node);
                node.setLeftChild(parent);
                node.setRightChild(parent.getRightChild());
            } else {
                heapElements.set(heapElements.indexOf(node), parent);
                heapElements.set(temp, node);
                node.setRightChild(parent);
                node.setLeftChild(parent.getLeftChild());
            }
        }
    }


    private Node getParent(Node child) {
        int childIndex = heapElements.indexOf(child) + 1 ;
        return heapElements.get(childIndex/2);
    }



}
