package com.geeks.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search algorithm in the disconnected graph.
 */
public class BFSDisconnectedGraph {

    public static void main(String[] args)
    {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);

        System.out.println("Following is Breadth First Traversal: ");
        BFSDin(adj,V);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFSDin(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for(int i = 0 ; i < V ; i++) {
            if (visited[i] == false) {
                BFS(adj, i, visited);
            }
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while(!q.isEmpty())
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : adj.get(u)) {
                if(visited[v] == false){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
