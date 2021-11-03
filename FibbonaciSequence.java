class FibbonaciSequence{
    /**
     * TC -  T(n) = T(n-1) + T(n-2) (exponential)
     * @param n
     * @return int - the number n in the fibonacci sequence
     */
    public static int fibbonaciRecursive(int n) {
        return n<=1 ? n : fibbonaciRecursive(n-1) + fibbonaciRecursive(n-2);  
    }

    /**
     * TC - O(n)
     * @param n
     * @return int - the number n in the fibonacci sequence
     */
    public static int fibbonaciDynamic(int n){
        // we make an array to store the numbers
        int fib[] = new int[n+2];

        // if n = 0 or 1
        fib[0] = 0; fib[1] = 1;

        for (int i = 2; i <= n ; i++){
            // fib(n) = fib(n-1) + fib(n-2) according to the formula
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    /**
     * Best approach I've seen - using the formula 
     * F(n) = {[(5^(1/2) + 1)/2] ^ n} / 5^(1/2) 
     * TC - O(log(n))
     * @param args
     * @return int - the number n in the fibonacci sequence
     */
    public static int fibbonaciFormula(int n){
        double phi = (1+ Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    /*
    public static void main(String[] args) {
       // System.out.println(fibbonaciRecursive(7));
       // System.out.println(fibbonaciDynamic(7));
       // System.out.println(fibbonaciFormula(7));
    }
    */
}
