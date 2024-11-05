public class fib1 {

    public static long[] printFibb(int n) {
        // Your code here

        long[] fib = new long[n];
        long temp1 = 1;
        long temp2 = 0;
        // long temp3=0;
        int a = 0;
        while (a < n) {

            long temp3 = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp3;
            System.out.println(temp1);
            a++;

        }
        return fib;

    }

    public static void main(String[] args) {
        printFibb(5);

    }

}
