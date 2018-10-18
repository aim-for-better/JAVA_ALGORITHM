package com.company.fourthchapter;

import firstchapter.Queue;
import javafx.scene.input.InputMethodTextRun;

import java.util.*;

/**
 * Created by zzy on 18-10-18.
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private java.util.Queue<Integer> post;
    private Deque<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {

        pre = new Queue<>();
        post = new LinkedList<>();
        reversePost = new ArrayDeque<>();

        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {

        marked[v] = true;

        pre.enque(v);

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.add(v);

        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
