package implementation.charsetPS;

import java.math.BigInteger;
import java.util.Scanner;

public class largeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr= sc.nextLine().split(" ");
        BigInteger in = new BigInteger(arr[0]);
        BigInteger in2 = new BigInteger(arr[1]);
        if (in.compareTo(in2) < 0 ) { // in < in2 == -1 in > in2 == 1
            System.out.println(in + " " + in2);
        } else if(in.compareTo(in2) > 0) {
            System.out.println(in2 + " "+ in);
        }
    }
}
