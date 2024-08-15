public class PatternSeventeen {
    public static void main(String args[]) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            int charCode = 65;
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print((char) (charCode) + " ");
                if (charCode % 2 == 0)
                    --charCode;
                else
                    ++charCode;
            }
            for (int j = n - i; j < n - 1; j++) {
                System.out.print((char) (charCode) + " ");
                if (charCode % 2 == 0)
                    --charCode;
                else
                    ++charCode;
            }
            System.out.println();
        }
    }
}
