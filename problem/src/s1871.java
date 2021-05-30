public class s1871 {
    public boolean canReach(String s, int minJump, int maxJump) {

        int[] pre = new int[s.length()];
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }

        for (int i = minJump; i < s.length(); i++) {
            int left = i - maxJump - 1;
            int right = i - minJump;

            if (s.charAt(i) == '0') {
                dp[i] = (pre[right] - (left < 0 ? 0 : pre[left])) != 0 ? 1 : 0;
            }

            pre[i] = pre[i - 1] + dp[i];
        }

        return dp[s.length() - 1] == 1;
    }


    public static void main(String[] args) {
        System.out.println(new s1871().canReach("011010", 2, 3));
    }
}
