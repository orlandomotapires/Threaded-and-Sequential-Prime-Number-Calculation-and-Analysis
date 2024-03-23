public class Trial_division_algorithm {
    public static boolean isPrime_Trial_division(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        
        for (int i = 2; i * i <= n; i++) { // Check divisibility by numbers from 2 up to the square root of n
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
