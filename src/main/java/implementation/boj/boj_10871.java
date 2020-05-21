package implementation.boj;

import java.util.Scanner;

public class boj_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int arr = sc.nextInt();
            if (arr < x) {
                System.out.println(arr);
            }
        }
    }
}

