package firstchapter;

/**
 * Created by zzy on 18-9-15.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        this.count =N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }

    public int count(){return count;}
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    private int find(int p){
        while(p!=id[p]){
            p=id[p];
        }
        return p;
    }

    public void union(int p, int q){
        int i=find(p);
        int j=find(q);
        if(i==j) return ;
        if(sz[i]<sz[j]){
            id[i]=id[j];
            sz[j]+=sz[i];
        }else{
            id[j]=id[i];
            sz[i]+=sz[j];
        }
        count--;
    }
}
