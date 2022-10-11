package com.geeks.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Write an algorithm for weighted and undirected graph using adjacency matrix representation aka Dijkstra Shortest path Algorithm
 */
public class DijkstraShortestPathAlgorithm {

    public static void main(String[] args) {
        int graph[][] = {
                {0, 50, 100, 0},
                {50, 0, 30, 200},
                {100, 30, 0, 20},
                {0, 200, 20, 0}
        };

        for (int x : djikstra(graph, 0, 4)) {
            System.out.print(x + " ");
        }
    }

    public static int[] djikstra(int graph[][], int src, int V) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] fin = new boolean[V];

        for (int count = 0; count < V - 1; count++) {
            int u = -1;

            for (int i = 0; i < V; i++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !fin[v]) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        return dist;
    }

    //By using adjacency list representation
    public static int[] dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int src) {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>( (v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new AdjListNode(src, 0));

        while (pq.size() > 0) {
            AdjListNode current = pq.poll();

            for (AdjListNode n :
                    graph.get(current.getVertex())) {
                if (distance[current.getVertex()]
                        + n.getWeight()
                        < distance[n.getVertex()]) {
                    distance[n.getVertex()]
                            = n.getWeight()
                            + distance[current.getVertex()];
                    pq.add(new AdjListNode(
                            n.getVertex(),
                            distance[n.getVertex()]));
                }
            }
        }
        return distance;
    }

    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w)
        {
            vertex = v;
            weight = w;
        }
        int getVertex() { return vertex; }
        int getWeight() { return weight; }
    }
}
