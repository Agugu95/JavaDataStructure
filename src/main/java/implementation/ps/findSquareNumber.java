package implementation.ps;

import java.util.Scanner;

public class findSquareNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        System.out.println(func3(in));
    }

    public static int func3(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return 1;
            }
        }
        return 0;
    }
}
