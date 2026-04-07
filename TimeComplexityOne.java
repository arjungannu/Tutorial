public class TimeComplexityOne {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println(i + j);
            }
            System.out.println("---");
        }
    }
}