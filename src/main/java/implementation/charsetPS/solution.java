package implementation.charsetPS;

import java.util.Arrays;
import java.util.Scanner;

public class solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums;
        String in = sc.nextLine();
        String[] arr = in.split(" ");
        nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        solution solution = new solution();;
        int a = sc.nextInt();
        System.out.println(Arrays.toString(solution.twoSum(nums, a)));
    }
}
