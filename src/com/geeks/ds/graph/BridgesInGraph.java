package com.geeks.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Finding the bridges in an undirected graph.
 */
public class BridgesInGraph {

    public static void main(String args[]) {
        System.out.println("Bridges in first graph ");
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.bridge();
    }

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void bridge() {
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
            }

            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    bridgeUtil(i, visited, disc, low, parent);
                }
            }
        }

        void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {

            visited[u] = true;
            disc[u] = low[u] = ++time;

            Iterator<Integer> itr = adj[u].iterator();
            while (itr.hasNext()) {
                int v = itr.next();

                if (!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);

                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) {
                        System.out.println(u + " " + v);
                    }
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

    }
    }
