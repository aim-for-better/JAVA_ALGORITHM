package com.company.fourthchapter;

import firstchapter.Queue;
import firstchapter.Stack;

/**
 * Created by zzy on 18-10-17.
 */
public class BreadthFirstPaths {
    private boolean [] marked;

    private int [] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G,int s){
        this.s=s;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        bfs(G,s);
    }

    private void bfs(Graph G,int s){

        Queue<Integer> queue=new Queue<Integer>();

        marked[s]=true;
        while(!queue.isEmpty()){
            int v=queue.deque();

            for(int w: G.adj(v)){
                if(!marked[w]){
                    marked[w]=true;
                    edgeTo[w]=v;
                    queue.enque(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){

        if(!hasPathTo(v)) return null;

        Stack<Integer> path=new Stack<>();

        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
