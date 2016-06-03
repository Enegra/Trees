package com.company;

import java.util.ArrayList;

/**
 * Created by agnie on 5/4/2016.
 */
public class BinaryTree {

    Node root;
    ArrayList<Node> incompleteNodes;

    public BinaryTree() {
        root = null;
        incompleteNodes = new ArrayList<Node>();
    }

    public BinaryTree(Node node) {
        root = node;
    }

    //to produce correct results for the entire tree I found it easiest to just keep record of current nodes that
    //don't have two children yet and always fill the oldest one first
    void insert(Node newNode) {
        if (root==null){
            root = newNode;
        }
        else{
            Node firstSlot = incompleteNodes.get(0);
            if (firstSlot.getLeftChild()==null){
                firstSlot.setLeftChild(newNode);
                if (firstSlot.getRightChild()!=null){
                    incompleteNodes.remove(0);
                }
            }
            else {
                firstSlot.setRightChild(newNode);
                incompleteNodes.remove(0);
            }
        }
        incompleteNodes.add(newNode);
    }

    public void insert(int data) {
        if (!find(data)) {
            Node newNode = new Node(data);
                insert(newNode);
        }
    }

    public boolean find(int data) {
        return root != null && find(root, data);
    }

    boolean find(Node node, int data) {
        if (node.getData() == data) {
            return true;
        }
        if (node.getLeftChild() != null) {
            if (find(node.getLeftChild(), data)) {
                return true;
            }
        }
        if (node.getRightChild() != null) {
            if (find(node.getRightChild(), data)) {
                return true;
            }
        }
        return false;
    }


    Node search(Node node, int data) {
        if (node != null) {
            if (node.getData() == data) {
                return node;
            } else {
                Node foundNode = search(node.getLeftChild(), data);
                if (foundNode == null) {
                    foundNode = search(node.getRightChild(), data);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }

    public Node search(int data){
        return search(root, data);
    }

    public Node getRoot() {
        return root;
    }

    public void remove(int data) {
        if (root == null) {
            System.out.println("The tree is empty");
        } else remove(root, root, data);
    }

    void remove(Node current, Node parent) {
        //removing leaf
        if (current.isLeaf()) {
            if (current == root) {
                root = null;
            } else if (parent.getLeftChild() == current) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        //one child, left
        else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (parent.getLeftChild() == current) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        }
        //one child, right
        else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (parent.getLeftChild() == current) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
        //two children
        else {
            // we need to replace the removed node with another one
            // for that we look for the farthest node down the right subtree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (parent.getLeftChild() == current) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
    }

    boolean remove(Node current, Node parent, int data) {
        if (current.getData() == data) {
           remove(current,parent);
            return true;
            }
         else {
            if (current.getLeftChild() != null) {
                if (remove(current.getLeftChild(), current, data)) {
                    return true;
                }
            }
            if (current.getRightChild() != null) {
                if (remove(current.getRightChild(), current, data)) {
                    return true;
                }
            }
        }
        return false;
    }

    Node getSuccessor(Node node) {
        Node successor = null;
        Node successorParent = null;
        Node current = node.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successorParent.getRightChild());
            System.out.println("Successor parent: " + successorParent.getData());
            successorParent.setRightChild(null);
            successor.setRightChild(node.getRightChild());
            if (incompleteNodes!=null){
            incompleteNodes.remove(successor);
            incompleteNodes.add(0, successorParent);
            }
        }
        return successor;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinaryTree subtree(int data) throws Exception {
        Node node = search(root, data);
        if (node == null) {
            throw new Exception("Such element doesn't exist");
        }
        return subtree(node);
    }

    BinaryTree subtree(Node node){
        return new BinaryTree(node);
    }

    public void print() {
        if (root != null) {
            print(root);
        } else {
            System.out.println("The tree is empty.");
        }
        System.out.println();
    }

     void print(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            print(node.getLeftChild());
            print(node.getRightChild());
        }
    }


    void path(Node startNode, Node endNode){
        if (startNode==null && endNode==null)
        {
            System.out.println("Nodes not found");
        }
        else {
            ArrayList<Node> path = new ArrayList<Node>();
            findPath(startNode, endNode, path);
            System.out.println("Path: ");
            for (int i=0; i<path.size(); i++){
                System.out.print(path.get(i).getData() + " ");
            }
            System.out.println();
        }
    }

    public void path(int end){
        Node endNode = search(root, end);
        path(root, endNode);
    }

    boolean findPath(Node root, Node node, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root == node){
            return true;
        }
        if(findPath (root.getLeftChild(), node, path) || findPath(root.getRightChild(), node, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }



}
