package com.company;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Main {
    private static int MAX=1005;
    private static int[][]city=new int[MAX][MAX];
    private static boolean isImportant(int [][]city,int v,int n,int m){
        Set<Integer> inbound=new HashSet<>();

        Set<Integer> outbound=new HashSet<>();

        Deque<Integer>  inq=new ArrayDeque<>();
        Deque<Integer>  outq=new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            if(city[i][v]==1){
                inq.addLast(i);
            }
        }


        while(!inq.isEmpty()){
            int u=inq.removeFirst();
            if(!inbound.contains(u)){
                inbound.add(u);
            }
            for(int i=1;i<=n;i++){
                if(city[i][u]==1){
                    inq.addLast(i);
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(city[v][i]==1){
                outq.addLast(i);
            }
        }

        while(!outq.isEmpty()){
            int u=outq.removeFirst();
            if(!outbound.contains(u)){
                outbound.add(u);
            }
            for(int i=1;i<=n;i++){
                if(city[u][i]==1){
                    outq.addLast(i);
                }
            }
        }


        if(inbound.size()>outbound.size()) return true;
        else return false;
    }

    private static int findImportant(int [][] city,int n,int m){
        int count=0;
        for(int i=1;i<=n;i++){
            if(isImportant(city,i,n,m)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            for(int i=0;i<MAX;i++){
                for(int j=0;j<MAX;j++){
                    city[i][j]=0;
                }
            }
            int n = in.nextInt();
            int m = in.nextInt();

            for(int i=0;i<m+1;i++){

                int u=in.nextInt();
                int v=in.nextInt();
                if(u==v) continue;
                city[u][v]=1;
            }
            System.out.println(findImportant(city,n,m));
        }
    }
}
