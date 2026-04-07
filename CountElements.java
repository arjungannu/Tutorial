class CountElements {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 1 };
        int maxCount = 0;
        int maxValue = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxValue) {
                maxValue = A[i];
                maxCount = 1;
            }
            // finds all the duplicate values of max_value keeps track using max_count
            else if (A[i] == maxValue) {
                maxCount += 1;
            }

        }
        System.out.println(A.length - maxCount);
    }
}
