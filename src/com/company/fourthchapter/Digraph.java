package com.company.fourthchapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzy on 18-10-17.
 */
public class Digraph {

    private final int V ;
    private int E;
    private List<Integer>[] adj;
    public Digraph(int v) {
        this.V = v;
        this.E=0;
        adj=(List<Integer>[])new List[V];

        for(int v=0;v<V;v++){
            adj[v]= new ArrayList<>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph R=new Digraph(V);

        for(int v=0;v<V;v++){
            for(int w:adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }
}
