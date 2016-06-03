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


}
