package Array;

public class LongestPalindromeInAString {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

    private static int longestPalSubstr(String str) {
        Boolean dp[][] = new Boolean[str.length()][str.length()];
        int len = 0;
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else dp[i][j] = false;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else dp[i][j] = false;
                }
                if (dp[i][j]) {
                    len = g + 1;
                }
            }
        }

        return len;
    }
}
