public class SquareRoot {

    public long solve(int A) {
        // for(int i=1; i*i<=A; i++)
        // {
        // if(i*i==A) return i;
        // }
        // return -1;
        int left = 2, right = A / 2;

        // since we search up to A/2
        while (right >= left) {
            long mid = (left + (right - left) / 2);
            System.out.println("mid " + mid);
            long square = mid * mid;
            System.out.println("square " + square);
            if (square == A)
                return mid;
            else if (square > A)
                right = (int) mid - 1;
            else
                left = (int) mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        SquareRoot s = new SquareRoot();
        System.out.println(s.solve(1065024));
    }
}
