package firstchapter;

/**
 * Created by zzy on 18-9-15.
 */
public class LinkedListOperate {

    private static   class Node{
        Integer item;
        Node next;
    }


    /**
     * 通过循环的方式反转链表
     * @param x
     * @return
     */
    public static Node reverse(Node x){

        Node first=x;  // we do not want to modify x
        Node reverse=null;
        while(first!=null){
            Node next=first.next;
            first.next=reverse;
            reverse=first;
            first=next;
        }
        return reverse;
    }


    public static Node reverse2(Node first){

        if(first==null||first.next==null) return first;

        Node second=first.next;
        Node rest=reverse2(second);
        second.next=first;
        first.next=null;
        return rest;
    }

    /**
     * 从原链表中, 从1开始, 抽取奇数位上节点组成新的链表
     * @param x
     * @return
     */
    public static Node  oddList(Node x){

        if(x==null||x.next==null) return x;

        Node first=x;
        while(first!=null&&first.next!=null){
            Node next=first.next.next; // move 2 step
            first.next=next;
            first=next;
        }
        return x;
    }

    public static   Node buildNodeList(){
        Node x=new Node();
        x.item= new Integer(1);
        Node first=x;
       for(int i=2;i<11;i++){
          Node tmp=new Node();
          tmp.item=i;
          tmp.next=null;
          first.next=tmp;
          first=tmp;

       }
        return x;
    }

    public static void showNodeList(Node x){
        if(x==null) return ;
        while(x!=null){
            System.out.print(x.item+"-->");
            x=x.next;
        }
        System.out.println();
    }


    public static void test(){
        Node x=buildNodeList();
        showNodeList(x);

        Node reveseNode=reverse(x);
        showNodeList(reveseNode);
    }
    public static void main(String[] args){

        test();
    }
}
