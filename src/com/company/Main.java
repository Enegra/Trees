package com.company;

public class Main {

    public static void presentBinaryTree() throws Exception {
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Binary Tree");
        System.out.println();
        System.out.println("Adding node: 2");
        binaryTree.insert(2);
        binaryTree.print();
        System.out.println("Adding node: 4");
        binaryTree.insert(4);
        binaryTree.print();
        System.out.println("Adding node: 6");
        binaryTree.insert(6);
        binaryTree.print();
        System.out.println("Adding node: 7");
        binaryTree.insert(7);
        binaryTree.print();
        System.out.println("Adding node: 8");
        binaryTree.insert(8);
        binaryTree.print();
        System.out.println("Adding node: 9");
        binaryTree.insert(9);
        binaryTree.print();
        System.out.println("Adding node: 10");
        binaryTree.insert(10);
        binaryTree.print();
        System.out.println("Adding node: 11");
        binaryTree.insert(11);
        binaryTree.insert(12);
        binaryTree.insert(13);
        binaryTree.insert(14);
        binaryTree.insert(15);
        binaryTree.print();

        System.out.println();
        System.out.println("Removing node: 4");
        binaryTree.remove(4);
        binaryTree.print();

        System.out.println();
        System.out.println("Subtree from node: 6");
        BinaryTree subtree = binaryTree.subtree(6);
        subtree.print();
        System.out.println();

        System.out.println("Path between nodes: root, 8");
        binaryTree.path(8);

    }

    public static void presentBST() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("Binary Tree");
        System.out.println();
        System.out.println("Adding node: 15");
        binarySearchTree.insert(15);
        binarySearchTree.print();
        System.out.println("Adding node: 4");
        binarySearchTree.insert(4);
        binarySearchTree.print();
        System.out.println("Adding node: 5");
        binarySearchTree.insert(5);
        binarySearchTree.print();
        System.out.println("Adding node: 8");
        binarySearchTree.insert(8);
        binarySearchTree.print();
        System.out.println("Adding node: 1");
        binarySearchTree.insert(1);
        binarySearchTree.print();
        System.out.println("Adding node: 19");
        binarySearchTree.insert(19);
        binarySearchTree.print();
        System.out.println("Adding node: 21");
        binarySearchTree.insert(21);
        binarySearchTree.print();
        System.out.println("Adding node: 2");
        binarySearchTree.insert(2);
        binarySearchTree.print();
        System.out.println("Removing node: 4");
        binarySearchTree.remove(4);
        binarySearchTree.print();

        System.out.println("Subtree from node: 5");
        BinaryTree subtree = binarySearchTree.subtree(5);
        subtree.print();
        System.out.println();
    }

    public static void presentAVL() throws Exception {
        AVLTree avlTree = new AVLTree();
        System.out.println("Binary Tree");
        System.out.println();
        System.out.println("Adding node: 15");
        avlTree.insert(15);
        avlTree.print();
        System.out.println("Adding node: 4");
        avlTree.insert(4);
        avlTree.print();
        System.out.println("Adding node: 5");
        avlTree.insert(5);
        avlTree.print();
        System.out.println("Adding node: 8");
        avlTree.insert(8);
        avlTree.print();
        System.out.println("Adding node: 1");
        avlTree.insert(1);
        avlTree.print();
        System.out.println("Adding node: 19");
        avlTree.insert(19);
        avlTree.print();
        System.out.println("Adding node: 21");
        avlTree.insert(21);
        avlTree.print();
        System.out.println("Adding node: 2");
        avlTree.insert(2);
        avlTree.print();
        System.out.println("Removing node: 4");
        avlTree.remove(4);
        avlTree.print();
        System.out.println("Adding node: 7");
        avlTree.insert(7);
        avlTree.print();
        System.out.println("Adding node: 9");
        avlTree.insert(9);
        avlTree.print();
        System.out.println("Adding node: 23");
        avlTree.insert(23);
        avlTree.print();
        System.out.println("Adding node: 28");
        avlTree.insert(28);
        avlTree.print();
        System.out.println("Adding node: 35");
        avlTree.insert(35);
        avlTree.print();
        System.out.println("Adding node: 45");
        avlTree.insert(45);
        avlTree.print();
        System.out.println("Adding node: 41");
        avlTree.insert(41);
        avlTree.print();
        System.out.println("Adding node: 55");
        avlTree.insert(55);
        avlTree.print();
//
//
//
//
//        System.out.println("Subtree from node: 5");
//        BinaryTree subtree = avlTree.subtree(5);
//        subtree.print();
//        System.out.println();
    }

    public static void main(String[] args) throws Exception {
//        presentBinaryTree();
//        presentBST();
        presentAVL();
    }
}
