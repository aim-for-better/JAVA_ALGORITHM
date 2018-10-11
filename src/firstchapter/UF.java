package firstchapter;

/**
 * Created by zzy on 18-9-15.
 */
public class UF {

    private int[] id;
    private int count;

    public UF(int N){
        count=N;
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }


    /**
     * quick-find
     * @param p
     * @return
     */
    private int find(int p){
        return id[p];
    }


    /**
     * slow union
     * @param p
     * @param q
     */
    private void union(int p,int q){

        int pId=find(p);
        int qId=find(q);
        if(pId==qId) return ;
        for(int i=0;i<id.length;i++){
            if(id[i]==pId){
                id[i]=qId;
            }
        }

        count--;
    }
}
