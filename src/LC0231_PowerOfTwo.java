public class LC0231_PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(256));
        System.out.println(isPowerOfTwo(253));
        System.out.println(isPowerOfTwo(-100));
        System.out.println(isPowerOfTwo(1));
    }

    public static boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        }

        while (n >= 2) {

            if (n == 2) {
                return true;
            } else if (n % 2 != 0) {
                return false;
            }

            n = n / 2;

        }
        return false;
    }

}
