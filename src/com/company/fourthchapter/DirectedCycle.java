package com.company.fourthchapter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zzy on 18-10-18.
 */
public class DirectedCycle {

    private boolean[] marked;

    private int[] edgeTo;

    private Deque<Integer> cycle;

    private boolean[] onStack;

    public DirectedCycle(Digraph G){
        onStack=new boolean[G.V()];
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        for(int v=0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int v){
        onStack[v]=true;
        marked[v]=true;
        for(int w:G.adj(v)){
            if(this.hasCycle()) return;
            else if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }else if(onStack[w]){
                cycle=new ArrayDeque<>();
                for(int x=v;x!=w;x=edgeTo[v]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v]=false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
}
