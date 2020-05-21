package implementation.ps;

public class findSum100 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();*/
        System.out.println(func2(new int[]{4, 13, 63, 53, 83, 3}, 6));
    }

    public static int func2(int[] arr, int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] + arr[n - 1] == 100) {
                return 1;
            }
        }
        return 0;
    }
}
