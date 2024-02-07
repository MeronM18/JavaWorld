public class Fibonacci {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Fibonacci <position>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        if (n < 0) {
            System.out.println("Please enter a non-negative number.");
            return;
        }

        long fibNumber = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + fibNumber);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }
}
