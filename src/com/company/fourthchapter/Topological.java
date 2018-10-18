package com.company.fourthchapter;

/**
 * Created by zzy on 18-10-18.
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph G){

        DirectedCycle cycleFinder=new DirectedCycle(G);

        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(G);
            order=dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order!=null;
    }


}
