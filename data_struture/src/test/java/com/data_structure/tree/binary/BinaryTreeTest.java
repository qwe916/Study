package com.data_structure.tree.binary;

import com.sun.source.tree.BinaryTree;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    @Test
    void binaryTreeTest() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(20);

        binaryTree.inorder();
    }

    static class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        // 삽입 메소드
        void insert(int key) {
            root = insertRec(root, key);
        }

        // 재귀적으로 노드를 삽입
        private Node insertRec(Node root, int key) {
            // 트리가 비어있으면 새로운 노드를 반환
            if (root == null) {
                root = new Node(key);
                return root;
            }

            // 키가 현재 루트보다 작으면 왼쪽 서브트리에 삽입
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key) // 키가 현재 루트보다 크면 오른쪽 서브트리에 삽입
                root.right = insertRec(root.right, key);

            return root;
        }

        // 중위순회 (Inorder Traversal)
        void inorder() {
            inorderRec(root);
        }

        // 재귀적으로 중위순회
        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }
    }
}
