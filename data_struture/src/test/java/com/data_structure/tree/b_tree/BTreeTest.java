package com.data_structure.tree.b_tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BTreeTest {
    @Test
    void bTreeTest() {
        BTree bTree = new BTree(3);

        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);

        bTree.traverse();

        BTreeNode search = bTree.search(6);
        Assertions.assertThat(search.keys).contains(6);
    }

    static class BTreeNode {
        int[] keys;
        int t;  // 최소 차수
        BTreeNode[] C;
        int n;
        boolean leaf;

        public BTreeNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            this.keys = new int[2 * t - 1];
            this.C = new BTreeNode[2 * t];
            this.n = 0;
        }

        public void traverse() {
            int i;
            for (i = 0; i < n; i++) {
                if (!leaf)
                    C[i].traverse();
                System.out.print(" " + keys[i]);
            }

            if (!leaf)
                C[i].traverse();
        }

        public BTreeNode search(int k) {
            int i = 0;
            while (i < n && k > keys[i])
                i++;

            if (keys[i] == k)
                return this;

            if (leaf)
                return null;

            return C[i].search(k);
        }
    }

    static class BTree {
        BTreeNode root;
        int t;  // 최소 차수

        public BTree(int t) {
            this.root = null;
            this.t = t;
        }

        public void traverse() {
            if (root != null)
                root.traverse();
        }

        public BTreeNode search(int k) {
            return (root == null) ? null : root.search(k);
        }

        public void insert(int k) {
            if (root == null) {
                root = new BTreeNode(t, true);
                root.keys[0] = k;
                root.n = 1;
            } else {
                if (root.n == 2 * t - 1) {
                    BTreeNode s = new BTreeNode(t, false);
                    s.C[0] = root;
                    splitChild(s, 0, root);
                    int i = 0;
                    if (s.keys[0] < k)
                        i++;
                    insertNonFull(s.C[i], k);
                    root = s;
                } else
                    insertNonFull(root, k);
            }
        }

        private void insertNonFull(BTreeNode x, int k) {
            int i = x.n - 1;

            if (x.leaf) {
                while (i >= 0 && x.keys[i] > k) {
                    x.keys[i + 1] = x.keys[i];
                    i--;
                }
                x.keys[i + 1] = k;
                x.n = x.n + 1;
            } else {
                while (i >= 0 && x.keys[i] > k)
                    i--;
                if (x.C[i + 1].n == 2 * t - 1) {
                    splitChild(x, i + 1, x.C[i + 1]);
                    if (x.keys[i + 1] < k)
                        i++;
                }
                insertNonFull(x.C[i + 1], k);
            }
        }

        private void splitChild(BTreeNode x, int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.t, y.leaf);
            z.n = t - 1;

            if (t - 1 >= 0) System.arraycopy(y.keys, t, z.keys, 0, t - 1);

            if (!y.leaf) {
                if (t >= 0) System.arraycopy(y.C, t, z.C, 0, t);
            }

            y.n = t - 1;

            for (int j = x.n; j >= i + 1; j--)
                x.C[j + 1] = x.C[j];

            x.C[i + 1] = z;

            for (int j = x.n - 1; j >= i; j--)
                x.keys[j + 1] = x.keys[j];

            x.keys[i] = y.keys[t - 1];
            x.n = x.n + 1;
        }
    }
}

