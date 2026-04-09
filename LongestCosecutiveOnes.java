public class LongestCosecutiveOnes {
    public static int findMaxConsecutiveOnesExpand(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int maxLength = 0;
        int n = A.length;
        boolean hasZero = false; // To track if we even have a 0 to flip

        // Outer loop: Find the zeros
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                hasZero = true;
                int leftCount = 0;
                int rightCount = 0;

                // Inner loop 1: Count consecutive 1s to the left
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] == 1)
                        leftCount++;
                    else
                        break; // Stop immediately at the next zero
                }

                // Inner loop 2: Count consecutive 1s to the right
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == 1)
                        rightCount++;
                    else
                        break; // Stop immediately at the next zero
                }

                // The total length if we flip this specific zero
                maxLength = Math.max(maxLength, leftCount + rightCount + 1);
            }
        }

        // Edge case: If the array was entirely 1s, we never entered the IF block
        return hasZero ? maxLength : n;
    }

    public static void main(String[] args) {
        int[] A = { 1, 1, 0, 0, 1, 1, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnesExpand(A));
    }
}
