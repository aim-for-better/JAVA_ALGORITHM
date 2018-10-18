package com.company.fourthchapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by zzy on 18-10-13.
 */
public class DepthFirstPaths {
    private boolean[]  marked;

    private int[] edgeTo;

    private final int s;

    public DepthFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v]=true;
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path=new Stack<>();
        for(int x=v;x!=s;x=edgeTo[v]){
            path.push(x);
        }
        path.push(s);
        return path;

    }
}
