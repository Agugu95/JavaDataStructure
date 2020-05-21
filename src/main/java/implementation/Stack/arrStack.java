package implementation.Stack;

public class arrStack {
    static class Stack {
        private int top;
        private int stackSize;
        private int stackArr[];

        public Stack(int stackSize) {
            top = -1;
            stackArr = new int[stackSize];
            this.stackSize = stackSize;
        }

        public void push(int data) {
            stackArr[++top] = data;
        }

        public int pop(){
            if (top == -1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return stackArr[top--];
        }

        public int peek() {
            if (top == -1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return stackArr[top];
        }

        public void printStack() {
            System.out.println("stack list");
            for (int i = top; i >= 0; --i) {
                System.out.println(stackArr[i]);
            }
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack(100);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.printStack();
        System.out.println("peek: " + st.peek());
        st.pop();
        st.printStack();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.printStack();
    }
}
