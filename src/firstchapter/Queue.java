package firstchapter;

/**
 * Created by zzy on 18-9-14.
 */
public class Queue<Item> {
    private Node first;
    private Node last;

    private int N;

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){return N;}

    public void enque(Item item){
        Node oldlast=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if( isEmpty()){
            first=last;
        }else{
            oldlast.next=last;
        }

        N++;
    }

    public Item deque(){
        Item item =first.item;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
        N--;
        return item;
    }

    private class Node{
        Item item;
        Node next;
    }

    public static void main(String[] args){
        Queue<Integer> q=new Queue<>();
        q.deque();
    }
}
