public class PrimeNumber {

    // Check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Print all prime numbers up to n
    public static void printPrimes(int n) {
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Find first n prime numbers
    public static void firstNPrimes(int count) {
        System.out.println("First " + count + " prime numbers:");
        int num = 2;
        int found = 0;
        while (found < count) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                found++;
            }
            num++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Check if a number is prime
        int testNumber = 17;
        System.out.println(testNumber + " is " + (isPrime(testNumber) ? "Prime" : "Not Prime"));

        System.out.println();

        // Print primes up to 50
        printPrimes(50);

        System.out.println();

        // Print first 10 primes
        firstNPrimes(10);
    }
}
