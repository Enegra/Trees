package com.company;

/**
 * Created by agnie on 5/1/2016.
 */
public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;
    private int height;

    //node constructor, setting default values
    public Node(int data){
        this.data = data;
        leftChild = null;
        rightChild = null;
        height = 1;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild=leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public void setRightChild(Node rightChild){
        this.rightChild=rightChild;
    }

    public boolean equals(Node otherNode){
        return this.data == otherNode.data;
    }

    public boolean isLeaf() {
        return (getLeftChild() == null && getRightChild() == null);
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height=height;
    }

}
