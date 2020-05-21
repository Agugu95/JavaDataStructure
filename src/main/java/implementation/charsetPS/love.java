package implementation.charsetPS;

import java.util.Scanner;

public class love {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        if (s.equals("love")) {
            s = "I love you.";
            System.out.println(s);
        }
    }
}
