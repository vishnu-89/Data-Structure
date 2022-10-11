package com.geeks.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Find the articulation point for a connected and undirected graph.
 */
public class ArticulationPointInGraph {

    public static void main(String args[])
    {
        System.out.println("Articulation points in first graph ");
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.AP();
        System.out.println();
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

        void AP() {

            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            boolean ap[] = new boolean[V];


            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
            }

            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    APUtil(i, visited, disc, low, parent, ap);
                }
            }

            for (int i = 0; i < V; i++) {
                if (ap[i] == true) {
                    System.out.print(i + " ");
                }
            }
        }

        void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {

            int children = 0;
            visited[u] = true;
            disc[u] = low[u] = ++time;

            Iterator<Integer> itr = adj[u].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited[v]) {
                    children++;
                    parent[v] = u;
                    APUtil(v, visited, disc, low, parent, ap);

                    low[u] = Math.min(low[u], low[v]);
                    if (parent[u] == NIL && children > 1) {
                        ap[u] = true;
                    }
                    if (parent[u] != NIL && low[v] >= disc[u]) {
                        ap[u] = true;
                    }
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

    }
    }
