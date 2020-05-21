package implementation.charsetPS;

import java.util.Scanner;
import java.util.Stack;

public class bracket {
    public static void main(String[] args) {
        String in = "";
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuffer sbf = new StringBuffer();
        in = sc.nextLine();
        int inCount = 0;
        int outCount = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(') {
                stack.push(in.charAt(i));
                inCount++;
            } else {
                if (!stack.isEmpty()) {
                    sbf.append(stack.pop());
                }
                sbf.append(in.charAt(i));
                outCount++;
            }
        }
        System.out.println(sbf);
        System.out.println(inCount + " " + outCount);
    }
}
