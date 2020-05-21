package implementation.charsetPS;

import java.util.Scanner;

public class digitNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 0;
        int temp = 0;
        while(true) {
            temp = num % 10;
            System.out.println("각 자릿수: " + temp);
            result += temp;
            num = num / 10;
            if (num == 0) {
                System.out.println(result);
                break;
            }
        }

    }
}
