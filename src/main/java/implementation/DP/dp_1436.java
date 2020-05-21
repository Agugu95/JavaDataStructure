package implementation.DP;

import java.util.Scanner;

public class dp_1436 {
    public static int dp(int a, int count){
        if (a == 1) return count;
        if (a % 3 == 0) {
            a /= 3;
            count++;
            return dp(a, count);
        } else if (a % 2 == 0) {
            a /= 2;
            count++;
            return dp(a, count);
        } else {
            a -=1;
            count++;
            return dp(a, count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        int count = 0;
        if (in >= 1 && in < Math.pow(10, 6)) {
            in -= 1;
            count++;
            System.out.println(dp(in, count));
        }
    }
}
