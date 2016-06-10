package com.company;

public class Main {

    static void presentBinaryTree() throws Exception {
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

    static void presentBST() throws Exception {
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
        System.out.println("Adding node: 7");
        binarySearchTree.insert(7);
        binarySearchTree.print();
        System.out.println("Adding node: 9");
        binarySearchTree.insert(9);
        binarySearchTree.print();
        System.out.println("Adding node: 23");
        binarySearchTree.insert(23);
        binarySearchTree.print();
        System.out.println("Adding node: 28");
        binarySearchTree.insert(28);
        binarySearchTree.print();
        System.out.println("Adding node: 35");
        binarySearchTree.insert(35);
        binarySearchTree.print();
        System.out.println("Adding node: 45");
        binarySearchTree.insert(45);
        binarySearchTree.print();
        System.out.println("Adding node: 41");
        binarySearchTree.insert(41);
        binarySearchTree.print();
        System.out.println("Adding node: 55");
        binarySearchTree.insert(55);
        binarySearchTree.print();
        System.out.println("Path between nodes: root, 35");
        binarySearchTree.path(35);

    }

    static void presentAVL() throws Exception {
        AVLTree avlTree = new AVLTree();
        System.out.println("AVL Tree");
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
        System.out.println("Subtree from node: 5");
        BinaryTree subtree = avlTree.subtree(5);
        subtree.print();
        System.out.println();
        System.out.println("Path between nodes: root, 35");
        avlTree.path(35);

    }

    static void presentHeap() throws Exception {
        Heap heap = new Heap();
        System.out.println("Heap");
        System.out.println();
        System.out.println("Adding node: 4");
        heap.insert(4);
        heap.print();
        System.out.println("Adding node: 2");
        heap.insert(2);
        heap.print();
        System.out.println("Adding node: 9");
        heap.insert(9);
        heap.print();
        System.out.println("Adding node: 7");
        heap.insert(7);
        heap.print();
        System.out.println("Adding node: 1");
        heap.insert(1);
        heap.print();
        System.out.println("Adding node: 6");
        heap.insert(6);
        heap.print();
        System.out.println("Adding node: 3");
        heap.insert(3);
        heap.print();
        System.out.println("Adding node: 11");
        heap.insert(11);
        heap.print();
        System.out.println("Adding node: 12");
        heap.insert(12);
        heap.print();
        System.out.println("Adding node: 13");
        heap.insert(13);
        heap.print();
        System.out.println("Adding node: 14");
        heap.insert(14);
        heap.print();
        System.out.println("Adding node: 15");
        heap.insert(15);
        heap.print();
        System.out.println("Removing node: 2");
        heap.remove(2);
        heap.print();
        System.out.println();
        System.out.println("Removing node: 4");
        heap.remove(4);
        heap.print();

        System.out.println();
        System.out.println("Subtree from node: 11");
        BinaryTree subtree = heap.subtree(11);
        subtree.print();
        System.out.println();

        System.out.println("Path between nodes: root, 11");
        heap.path(11);
    }

    static void presentMaxHeap() throws Exception {
        Heap maxHeap = new Heap(false);
        System.out.println("Heap");
        System.out.println();
        System.out.println("Adding node: 4");
        maxHeap.insert(4);
        maxHeap.print();
        System.out.println("Adding node: 2");
        maxHeap.insert(2);
        maxHeap.print();
        System.out.println("Adding node: 9");
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("Adding node: 7");
        maxHeap.insert(7);
        maxHeap.print();
        System.out.println("Adding node: 1");
        maxHeap.insert(1);
        maxHeap.print();
        System.out.println("Adding node: 6");
        maxHeap.insert(6);
        maxHeap.print();
        System.out.println("Adding node: 3");
        maxHeap.insert(3);
        maxHeap.print();
        System.out.println("Adding node: 11");
        maxHeap.insert(11);
        maxHeap.print();
        System.out.println("Adding node: 12");
        maxHeap.insert(12);
        maxHeap.print();
        System.out.println("Adding node: 13");
        maxHeap.insert(13);
        maxHeap.print();
        System.out.println("Adding node: 14");
        maxHeap.insert(14);
        maxHeap.print();
        System.out.println("Adding node: 15");
        maxHeap.insert(15);
        maxHeap.print();
        System.out.println("Removing node: 2");
        maxHeap.remove(2);
        maxHeap.print();
        System.out.println();
        System.out.println("Removing node: 4");
        maxHeap.remove(4);
        maxHeap.print();

        System.out.println();
        System.out.println("Subtree from node: 11");
        BinaryTree subtree = maxHeap.subtree(11);
        subtree.print();
        System.out.println();

        System.out.println("Path between nodes: root, 11");
        maxHeap.path(11);
    }

    public static void main(String[] args) throws Exception {
//        presentBinaryTree();
//        presentBST();
//        presentAVL();
//        presentHeap();
        presentMaxHeap();
    }
}
