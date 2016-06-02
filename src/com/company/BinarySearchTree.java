package com.company;

/**
 * Created by agnie on 5/1/2016.
 */
public class BinarySearchTree extends BinaryTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(Node parent, Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            if (parent.getData() > newNode.getData()) {
                if (parent.getLeftChild() == null) {
                    parent.setLeftChild(newNode);
                } else {
                    insert(parent.getLeftChild(), newNode);
                }
            } else {
                if (parent.getRightChild() == null) {
                    parent.setRightChild(newNode);
                } else {
                    insert(parent.getRightChild(), newNode);
                }
            }
        }

    }

    @Override
    public void insert(int data) {
        if (search(data) == null) {
            Node newNode = new Node(data);
            insert(root, newNode);
        }
    }


    @Override
    public Node search(int data) {
        return search(root, data);
    }

    @Override
    Node search(Node node, int data) {
        if (node != null) {
            if (node.getData() == data) {
                return node;
            } else {
                if (node.getData() > data) {
                    return search(node.getLeftChild(), data);
                } else {
                    return search(node.getRightChild(), data);
                }
            }

        } else {
            return null;
        }
    }

    @Override
    public boolean find(int data) {
        return root != null && search(data) != null;
    }

    @Override
    boolean remove(Node current, Node parent, int data) {
        if (current.getData() == data) {
            remove(current, parent);
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

    //we can use the remove function from the BT because it will work the same, due to nodes being sorted in BST
    //it will produce correct result
    @Override
    public void remove(int data) {
        if (root == null) {
            System.out.println("The tree is empty");
        } else remove(root, root, data);
    }

    public boolean isEmpty() {
        return root == null;
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
    public void path(int end) {
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

}
