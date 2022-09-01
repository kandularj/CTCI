package com.package1.trees;

/**
 * Construct a binary search tree using give post-order traversal
 */
//input {10, 5, 1, 7, 40, 50}
//last node is always root


public class BSTPostOrder {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Index {
        int index = 0;
    }
    public Node constructTreeUtil(int[] postOrder , Index postIndex, int key,
                                  int min , int max , int size){
        if(postIndex.index < 0)
            return null;

        Node root = null;

        if(key > min && key < max){
            root = new Node(key);
            postIndex.index--;

            if(postIndex.index >= 0){

                root.right = constructTreeUtil(postOrder, postIndex , postOrder[postIndex.index],
                        key, max , size);

                root.left = constructTreeUtil(postOrder, postIndex , postOrder[postIndex.index],
                                                min, key , size);

            }
        }
        return root;

    }
    public Node constructTree(int[] postOrder , int size){
        Index postIndex = new Index();
        postIndex.index = size - 1;
        return constructTreeUtil(postOrder , postIndex, postOrder[postIndex.index],
                Integer.MIN_VALUE , Integer.MAX_VALUE , size);
    }
    public void printInOrder(Node node){
        if(node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);

    }
    public static void main(String[] args){
        int[] postOrder =  {1, 7, 5, 50, 40, 10};
        int size = postOrder.length;
        BSTPostOrder post = new BSTPostOrder();
        Node root = post.constructTree(postOrder , size);
        post.printInOrder(root);
    }
}

