package implementation.Stack;

import java.util.Stack;

public class utilStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int i = 0; i <= 2; i++) {
            System.out.println(stack.pop());
        }
    }
}
