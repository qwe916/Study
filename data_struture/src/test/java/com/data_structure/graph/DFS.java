package com.data_structure.graph;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class DFS {
    @Test
    void dfsTest() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.DFS(2);
    }

    static class Graph {
        private final int V;
        private final LinkedList<Integer>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");

            for (int n : adj[v]) {
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // DFS algorithm
        void DFS(int v) {
            boolean[] visited = new boolean[V];
            DFSUtil(v, visited);
        }
    }
}
