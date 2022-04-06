package modules;

import utility.FibFunction;

public class FibModule {

    public static long fib(int n) {
        //END CASE : TERMINATING CONDITIONS
        if(n == 0)
            return 0;
        else if( n == 1)
            return 1;

        //RECURSIVE CASE : CALLING THE FUNCTION WITHIN ITSELF
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static long ifib(int n) {
        int sum         = 0;
        int currentNum  = 1;
        int lastNum     = 0;
        int lastLastNum;
        for (int i = 1; i < n ; i ++){
            lastLastNum = lastNum;
            lastNum = currentNum;
            sum = lastNum + lastLastNum;
            currentNum = sum;
        }
        return sum;
    }

    public static long mfib(int n) {
        if(n == 0) {
            return 0;
        } else if( n == 1) {
            return 1;
        } else {
            long[] x = new long[n];
            x[0] = 0;
            x[1] = 1;

            if (n != 2) {
                x[n - 1] = memo(n -1, x);
            }
            return x[n -1] + x[n -2];
        }
    }

    private static long memo(int n, long[] x) {
        if ( x[n] == 0) {                             // if the value of the array is 0 (empty)
            x[n] = memo(n - 1, x) + x[n - 2];
        }
        return x[n];
    }

    public static void print(FibFunction f, int n){
        // PRINTS : count of nth factorial
        System.out.print("------------------------- nth Fibonnacci ");
        System.out.println("-----------------------");
        for (int i = 0; i <= n; i++ ) {
            System.out.print(i + "\t");
        }
        System.out.println();

        //PRINTS : value for nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.print(f.fib(i) + "\t");
        }
        System.out.println();
    }
}
