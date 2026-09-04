import java.util.Scanner;
public class TwoDigitStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return; 
        int t = Integer.parseInt(sc.nextLine()); 

        while (t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();

            int r = a.length();
            int c = b.length();

            int[] ar1 = new int[r+1];
            int[] ar2 = new int[c+1];
            for (int i = 1; i <= r; i++) {
                int digit = a.charAt(i-1) - '0'; 
                ar1[i] = (ar1[i-1] + digit) % 10;
            }
            for (int i = 1; i <= c; i++) {
                int digit = b.charAt(i-1) - '0';
                ar2[i] = (ar2[i-1] + digit) % 10;
            }
            if (ar1[r] != ar2[c]) {
                System.out.println(-1);
                continue;
            }
            int[][] dp = new int[r+1][c+1];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    if (ar1[i] == ar2[j]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            System.out.println(dp[r][c]);
        }
    }
}