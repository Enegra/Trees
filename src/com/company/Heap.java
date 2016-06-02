package com.company;

import java.util.ArrayList;

/**
 * Created by agnie on 6/2/2016.
 */
public class Heap extends BinaryTree {

    ArrayList<Node> heapElements;

    public Heap(){
        incompleteNodes = new ArrayList<Node>();
    }
}
