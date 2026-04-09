public class SubArrayWithGivenSum {

    public static int withFixedLengthWindow(int[] A, int targetSum, int B) {
        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }
        if (currentSum == targetSum) {
            return 1;
        }
        for (int i = B; i < A.length; i++) {
            currentSum += A[i];
            currentSum -= A[i - B];
            if (currentSum == targetSum) {
                return 1;
            }
        }
        return 0;
    }

    public static int withSlidingWindowOnlyPositive(int[] A, int targetSum) {
        int left = 0;
        int currentSum = 0;
        for (int right = 0; right < A.length; right++) {
            currentSum += A[right];
            while (currentSum > targetSum && left <= right) {
                currentSum -= A[left];
                left++;
            }
            if (currentSum == targetSum) {
                return 1;
            }
        }
        return 0;
    }

    public static int withoutSlidingWindowNeg(int[] A, int targetSum) {
        java.util.HashSet<Integer> prefixSums = new java.util.HashSet<>();
        int currentSum = 0;
        prefixSums.add(0); // empty subarray has sum 0
        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            // If (currentSum - targetSum) was a previous prefix sum,
            // then the subarray between that point and here sums to targetSum
            if (prefixSums.contains(currentSum - targetSum)) {
                return 1;
            }
            prefixSums.add(currentSum);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = { -5, 2, 1, 4, 5 };
        int targetSum = 10;
        int B = 3;
        System.out.println(withFixedLengthWindow(A, targetSum, B));
        System.out.println(withSlidingWindowOnlyPositive(A, targetSum));
        System.out.println(withoutSlidingWindowNeg(A, targetSum));
    }
}
