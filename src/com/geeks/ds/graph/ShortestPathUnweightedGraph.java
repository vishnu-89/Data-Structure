package com.geeks.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an Unweighted Graph and a source point, the task is to find the shortest path
 * between the source point and every other point in the graph.
 */
public class ShortestPathUnweightedGraph {

    public static void main(String[] args)
    {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,0,2);
        addEdge(adj,1,3);

        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        BFS(adj,V,0,dist);

        for(int i = 0 ; i < V ; i++){
            System.out.print(dist[i]+" ");
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj,int V,int s, int[] dist)
    {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty())
        {
            int u = queue.poll();

            for(int v : adj.get(u)){
                if(visited[v] == false){
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
