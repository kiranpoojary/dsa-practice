public class PatternTen {
    public static void main(String args[]) {
        int n = 7;
        for (int i = 0; i < 2 * n - 1; i++) {
            int totalStars = i + 1;
            if (i >= n)
                totalStars = 2 * n - i - 1;
            for (int j = 0; j < totalStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
