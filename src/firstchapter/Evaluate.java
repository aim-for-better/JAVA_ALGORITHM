package firstchapter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by zzy on 18-9-12.
 */
public class Evaluate {
    public static void main(String[] args) {
        Deque<String> ops = new ArrayDeque<>();
        // ops.push(); //  push==addFirst
        Deque<Double> vals = new ArrayDeque<>();

        Scanner in = new Scanner(System.in);
        while (!in.hasNext()) {
            String s = in.nextLine();

            if (s.equals("(")) continue;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")){

                String op=ops.pop();

                double v=vals.pop();

                if(ops.equals("+")) {
                    v = vals.pop() + v;
                }else if(ops.equals("-")){
                    v=vals.pop()-v;
                }else if(ops.equals("*")){
                    v=vals.pop()/v;
                }

                vals.push(v);
            }else{
                vals.push(Double.parseDouble(s));
            }
        }

        System.out.println(vals.pop());
    }
}
