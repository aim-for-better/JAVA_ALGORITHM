package secondChapter;

/**
 * @Author: zzy
 * @Date: 2022-05-10
 * @Description: secondChapter
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private int[] pq; // heap structure, the value is the item related index which means pq[i]= k of item, qp[k]=i
    private int[] qp; // store the index in pq whose value is the item index k pq[qp[i]]=i, pq[i]= index, qp[index]=i
    private Item[] items;
    private int N=0;

    public IndexMinPQ(int maxN){
        items=(Item[]) new Comparable[maxN];
        pq=new int[maxN+1];
        qp=new int[maxN];

        for(int i=0;i<maxN;i++){
            pq[i]=-1;
        }
    }
    public void insert(int k, Item item){
        items[k]=item;
        pq[++N]=k;
        qp[k]=N;
        swim(N);
    }

    public void change(int k, Item item){
        items[k]=item;
        sink(k);
        swim(k);
    }

    public boolean contains(int k){
        return qp[k]!=-1;
    }

    public void delete(int k){
        exch(qp[k], N--);
        sink(qp[k]);
        swim(qp[k]);
        qp[pq[N+1]]=-1;
        items[pq[N+1]]=null;
    }

    public Item min(){
        return items[pq[1]];
    }

    public int minIndex(){
        return pq[1];
    }

    public int delMin(){
        int minIndex=pq[1];
        exch(1, N--);
        sink(1);
        items[N+1]=null;
        qp[pq[N+1]]=-1;
        return minIndex;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private void swim(int k){
        while(k>1 &&less(k, k/2)){
            exch(k, k/2);
            k=k/2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if(j<N && less(j+1, j)){
                j++;
            }
            if(!less(j, k)) break;
            exch(j, k);
            k=j;
        }
    }

    private boolean less(int i, int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    private void exch(int i, int j){
        // exch pq[i] and pq[j] to keep the heap
        int t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
        // update the qp
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
}
