package arr;

public class FindMissing {
    public int findMissed(int[] arr) {
        int n = arr.length;
        int found = 0;
        for (int i = 1; i <= arr.length; i++) {
            found = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = i;
                    break;
                }
            }
            if (found == 0) {
                return i;
            }
        }

        return found;

    }

    public int findMissedBetter(int[] arr) {
        int[] hashArr = new int[arr.length + 2];

        for (int i = 0; i < arr.length; i++) {
            hashArr[arr[i]] = arr[i];
        }

        for (int i = 1; i <= arr.length; i++) {
            if (hashArr[i] == 0)
                return i;
        }
        return 0;

    }

    public int findWithNSumBetter(int[] arr) {
        int n = arr[arr.length - 1]; // last num as our n
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }

    public int findMissedXorOptimal(int[] arr) {
        int expectedXOR = 0;
        for (int i = 1; i <= arr.length; i++) {
            expectedXOR = expectedXOR ^ i;
        }

        int actualXOR = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            actualXOR = actualXOR ^ arr[i];
        }
        return expectedXOR ^ actualXOR;
    }

    public int findMissedXorOptimalOtimal(int[] arr) {
        int expectedXOR = 0;
        int actualXOR = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            expectedXOR = expectedXOR ^ i + 1;
            actualXOR = actualXOR ^ arr[i];
        }
        expectedXOR = expectedXOR ^ arr.length;

        return expectedXOR ^ actualXOR;
    }

    public int myOptimal(int[] arr) { // tc: O(n), sc: O(0)
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9 };
        FindMissing f = new FindMissing();
        System.out.println(f.findMissed(arr));
        System.out.println(f.findMissedBetter(arr));
        System.out.println(f.findWithNSumBetter(arr));
        System.out.println(f.findMissedXorOptimal(arr));
        System.out.println(f.findMissedXorOptimalOtimal(arr));
        System.out.println(f.myOptimal(arr));

    }
}
