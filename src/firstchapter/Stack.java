package firstchapter;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by zzy on 18-9-14.
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first;

    private int N;

    public boolean isEmpty(){return first==null;}

    public int size(){return N;}

    public void push(Item item){
        Node oldfirst=first;

        first=new Node();
        first.item=item;
        first. next=oldfirst;
        N++;
    }

    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {

        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return first!=null;
        }

        public ListIterator() {
        }

        @Override
        public Item next() {
            Item item =first.item;

            first=first.next;
            return item;
        }
    }

    private class Node{
        Item item;
        Node next;
    }


}
