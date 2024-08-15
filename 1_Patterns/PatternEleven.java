public class PatternEleven {
    public static void main(String args[]) {
        int n = 7;
        for (int i = 1; i <= n; i++) {
            int start = i % 2;
            for (int j = n - i; j < n; j++) {
                System.out.print(start % 2 + " ");
                start++;
            }
            System.out.println();
        }
    }
}
