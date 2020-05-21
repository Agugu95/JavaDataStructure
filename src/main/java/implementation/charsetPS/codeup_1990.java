package implementation.charsetPS;

import java.math.BigInteger;
import java.util.Scanner;

public class codeup_1990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger big = new BigInteger(sc.nextLine());
        BigInteger big2 = BigInteger.valueOf(3);
        if (big.mod(big2).equals(BigInteger.ZERO)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
