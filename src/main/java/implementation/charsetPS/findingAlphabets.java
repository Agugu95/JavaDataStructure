package implementation.charsetPS;

import java.util.Scanner;

public class findingAlphabets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input != null && input.length() < 101) {
            for (char a = 'a'; a <= 'z'; a++){
                System.out.print(input.indexOf(a) + "\t");
            }
        }
    }
}
