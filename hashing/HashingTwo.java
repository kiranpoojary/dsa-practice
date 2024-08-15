package hashing;

public class HashingTwo {
    public static void main(String[] args) {
        // count number of each character(lowecase only) with O(n)
        String name = "kiran poojary";
        int[] charCount = new int[26];
        for (int i = 0; i < name.length(); i++) {
            int index = (int) name.charAt(i) - 97;
            if (index > 0) {
                charCount[index] = ++charCount[index];
            }
        }

        for (int i = 0; i < charCount.length; i++) {
            System.out.println((char) (i + 97) + ":-" + charCount[i]);
        }
    }
}
