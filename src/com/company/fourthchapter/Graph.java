package com.company.fourthchapter;

import firstchapter.Bag;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by zzy on 18-10-11.
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj =(Bag<Integer>[])  new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }
    public int E(){
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
