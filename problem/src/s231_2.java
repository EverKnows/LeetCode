public class s231_2 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return Integer.bitCount(n & Integer.MAX_VALUE) == 1;
    }

    public static void main(String[] args) {
        System.out.println(new s231_2().isPowerOfTwo(5));
    }
}
