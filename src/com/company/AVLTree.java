package com.company;

/**
 * Created by agnie on 5/31/2016.
 */
public class AVLTree extends BinarySearchTree {


    @Override
    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            recursiveInsert(root, node);
        }
    }


    Node recursiveInsert(Node current, Node newNode) {
        if (current == null) {
            current = newNode;
            return current;
        } else if (newNode.getData() < current.getData()) {
            current.setLeftChild(recursiveInsert(current.getLeftChild(), newNode));
            current = rebalance(current);
        } else if (newNode.getData() > current.getData()) {
            current.setRightChild(recursiveInsert(current.getRightChild(), newNode));
            current = rebalance(current);
        }
        return current;
    }


    private int maximum(int left, int right) {
        if (left > right) {
            return left;
        }
        return right;
    }

    private Node rotateRight(Node parent) {
        Node pivot = parent.getRightChild();
        parent.setRightChild(pivot.getLeftChild());
        pivot.setLeftChild(parent);
        if (parent == root) {
            root = pivot;
        }
        return pivot;
    }

    private Node rotateLeft(Node parent) {
        Node pivot = parent.getLeftChild();
        parent.setLeftChild(pivot.getRightChild());
        pivot.setRightChild(parent);
        if (parent == root) {
            root = pivot;
        }
        return pivot;
    }

    private Node rotateLeftRight(Node parent) {
        Node pivot = parent.getLeftChild();
        parent.setLeftChild(rotateRight(pivot));
        return rotateLeft(parent);
    }

    private Node rotateRightLeft(Node parent) {
        Node pivot = parent.getRightChild();
        parent.setRightChild(rotateLeft(pivot));
        return rotateRight(parent);
    }

    @Override
    public void remove(int data) {
        if (root == null) {
            System.out.println("The tree is empty");
        } else remove(root, root, data);
    }


    @Override
    boolean remove(Node current, Node parent, int data) {
        if (current.getData() == data) {
            remove(current, parent);
            rebalance(parent);
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


    private Node rebalance(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftChild()) > 0) {
                node = rotateLeft(node);
            } else {
                node = rotateLeftRight(node);
            }
        } else if (balance < -1) {
            if (getBalance(node.getRightChild()) > 0) {
                node = rotateRightLeft(node);
            } else {
                node = rotateRight(node);
            }
        }
        return node;
    }

    private int getBalance(Node node) {
        int left = getHeight(node.getLeftChild());
        int right = getHeight(node.getRightChild());
        int balance = left - right;
        return balance;
    }

    private int getHeight(Node node) {
        int height = 0;
        if (node != null) {
            int left = getHeight(node.getLeftChild());
            int right = getHeight(node.getRightChild());
            int largest = maximum(left, right);
            height = largest + 1;
        }
        return height;
    }


}
