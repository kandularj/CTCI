package com.package1.trees;

/**
 * Construct a binary search tree using give pre-order traversal
 */
    //input {10, 5, 1, 7, 40, 50}
    //first node is always root


public class BSTPreOrder {
    class Node{
        int data;
        Node left , right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }
    class Index{
        int index = 0;
    }

    Index index = new Index();
    //min and max takes minimum and maximum value of Integers respectively
    public Node constructTreeUtil(int preOrder[],Index preIndex,int key,
                                  int min, int max, int size){

        // Base case
        if (preIndex.index >= size) {
            return null;
        }

        Node root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if(key > min && key < max){

            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex.index ++;

            if(preIndex.index < size){
                // Construct the subtree under root
                // All nodes which are in range {min .. key}
                // will go in left subtree, and first such
                // node will be root of left subtree.
                root.left = constructTreeUtil(
                        preOrder, preIndex, preOrder[preIndex.index], min,
                        key, size);


                // Construct the subtree under root
                // All nodes which are in range {key .. maz}
                // will go in right subtree, and first such
                // node will be root of right subtree.
                root.right = constructTreeUtil(
                        preOrder, preIndex, preOrder[preIndex.index], key,
                        max, size);

            }

        }
        return root;

    }
    // The main function to construct BST from given
    // preorder traversal. This function mainly uses
    // constructTreeUtil()
    Node constructTree(int preOrder[], int size)
    {
        int preIndex = 0;
        return constructTreeUtil(preOrder, index, preOrder[0],
                Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }

    // A utility function to print inorder traversal of a
    // Binary Tree
    void printInorder(Node node)
    {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    public static void main(String[] args){

        BSTPreOrder binaryTree = new BSTPreOrder();
        int[] preOrder = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = preOrder.length;

        Node root = binaryTree.constructTree(preOrder ,size);
        binaryTree.printInorder(root);
    }

}
