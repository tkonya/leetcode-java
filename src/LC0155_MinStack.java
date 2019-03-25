import java.util.ArrayList;
import java.util.List;

public class LC0155_MinStack {

    public static void main(String[] args) {

        LC0155_MinStack runIt = new LC0155_MinStack();
        runIt.test();

    }

    public void test() {

        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }

    class MinStack {

        List<Integer> stack = new ArrayList<>();
        List<Integer> minStack = new ArrayList<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            stack.add(0, x);

            if (minStack.isEmpty()) {
                minStack.add(x);
            } else if (minStack.get(0) >= x) {
                minStack.add(0, x);
            } else {
                minStack.add(0, minStack.get(0));
            }
        }

        public void pop() {

            if (stack.size() < 2) {
                stack = new ArrayList<>();
                minStack = new ArrayList<>();
            } else {
                stack = stack.subList(1, stack.size());
                minStack = minStack.subList(1, minStack.size());
            }

        }

        public int top() {
            return stack.get(0);
        }

        public int getMin() {
            return minStack.get(0);
        }
    }



}
