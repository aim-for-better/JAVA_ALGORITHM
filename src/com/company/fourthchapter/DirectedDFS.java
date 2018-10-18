package com.company.fourthchapter;

import java.util.Iterator;

/**
 * Created by zzy on 18-10-18.
 */
public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        for(int s: sources){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }
    private void dfs(Digraph G,int v){

        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }

}
