package firstchapter;

import java.util.Iterator;

/**
 * Created by zzy on 18-9-14.
 */
public class Queue<Item> implements Iterable {
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

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<Item>{

        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {

            Item item=current.item;

            current=current.next;
            return item;
        }
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
