package implementation.charsetPS;

import java.util.Scanner;

public class digitNumberCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = Integer.parseInt(sc.nextLine());
        String input  = sc.nextLine();
        if (range <= 100) {
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                System.out.println("자릿수: " + (input.charAt(i)-'0'));
                sum += (input.charAt(i) - '0');
            }
            System.out.println(sum);
        }
    }
}

