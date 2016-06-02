package com.company;

/**
 * Created by agnie on 5/31/2016.
 */
public class AVLTree extends BinarySearchTree {

    Node root;

    public int getHeight(Node node){
        if (node!=null){
            return node.getHeight();
        }
        else return 0;
    }

    @Override
    public void insert(int data){
        if (search(data)==null) {
            Node node = new Node(data);
            insert(root, node);
        }
    }

    @Override
    void insert(Node parent, Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            if (parent.getData() > newNode.getData()) {
                if (parent.getLeftChild() == null) {
                    parent.setLeftChild(newNode);
                    parent.setHeight(maximum(getHeight(parent.getLeftChild()),getHeight(parent.getRightChild())) + 1);
                    rebalance(parent,parent.getData());
                } else {
                    insert(parent.getLeftChild(), newNode);
                }
            } else {
                if (parent.getRightChild() == null) {
                    parent.setRightChild(newNode);
                    parent.setHeight(maximum(getHeight(parent.getLeftChild()),getHeight(parent.getRightChild())) + 1);
                    rebalance(parent,parent.getData());
                } else {
                    insert(parent.getRightChild(), newNode);
                }
            }
        }

    }

    private int maximum(int left, int right){
        if (left>right) {
            return left;
        }
        else return right;
    }

    private Node rotateRight(Node parent){
        Node pivot = parent.getRightChild();
        parent.setRightChild(pivot.getLeftChild());
        pivot.setLeftChild(parent);
        pivot.setHeight(maximum(getHeight(pivot.getLeftChild()), getHeight(pivot.getRightChild())) +1);
        parent.setHeight(maximum(getHeight(parent.getLeftChild()), getHeight(parent.getRightChild())) +1);
        root = pivot;
        return pivot;
    }

    private Node rotateLeft(Node parent){
        Node pivot = parent.getLeftChild();
        parent.setLeftChild(pivot.getRightChild());
        pivot.setRightChild(parent);
        pivot.setHeight(maximum(getHeight(pivot.getLeftChild()),getHeight(pivot.getRightChild())) +1);
        parent.setHeight(maximum(getHeight(parent.getLeftChild()), getHeight(parent.getRightChild())) +1);
        root = pivot;
        return pivot;
    }

    private Node rotateLeftRight(Node parent){
        Node pivot = parent.getLeftChild();
        parent.setLeftChild(rotateRight(pivot));
        return rotateLeft(parent);
    }

    private Node rotateRightLeft(Node parent){
        Node pivot = parent.getRightChild();
        parent.setRightChild(rotateLeft(pivot));
        return rotateRight(parent);
    }

    int getBalance(Node node){
        if (node!=null){
            return (getHeight(node.getLeftChild()) - getHeight(node.getRightChild()));
        }
        else return 0;
    }

    @Override
    public void remove(int data){
        if (root == null) {
            System.out.println("The tree is empty");
        } else remove(root, root, data);
    }


    @Override
    boolean remove(Node current, Node parent, int data) {
        if (current.getData() == data) {
            remove(current, parent);
            rebalance(parent, parent.getData());
            return true;
        } else {
            if (data < current.getData()) {
                if (current.getLeftChild() != null) {
                    if (remove(current.getLeftChild(), current, data)) {
                        return true;
                    }
                }
            } else {
                if (current.getRightChild() != null) {
                    if (remove(current.getRightChild(), current, data)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Node search(int data){
        return search(root,data);
    }

    @Override
    public boolean find(int data) {
        return root != null && search(data)!=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void print() {
        if (root != null) {
            print(root);
        } else {
            System.out.println("The tree is empty.");
        }
        System.out.println();
    }

    @Override
    public void path(int end){
        Node endNode = search(root, end);
        path(root, endNode);
    }

    @Override
    public BinaryTree subtree(int data) throws Exception {
        Node node = search(root, data);
        if (node == null) {
            throw new Exception("Such element doesn't exist");
        }
        return subtree(node);
    }


    private void rebalance(Node node, int data){
        //checking node balance
        int balance = getBalance(node);
        //left case
        if (balance > 1 && data < node.getLeftChild().getData()) {
            rotateRight(node);
        }
        //right case
        else if (balance < -1 && data > node.getRightChild().getData()) {
            rotateLeft(node);
        }
        //left-right case
        else if (balance > 1 && data > node.getLeftChild().getData()) {
            rotateLeftRight(node);
        }
        //right-left case
        else if (balance < -1 && data < node.getRightChild().getData()) {
            rotateRightLeft(node);
        }
    }

}
