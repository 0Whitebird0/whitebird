    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.*;

    public class Main {
        static int T, n;
        static int[][] dp;
        static int[][] arr;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(bf.readLine());
            for(int i = 0; i < T; i++){
                n = Integer.parseInt(bf.readLine());
                arr = new int[2][n+1];
                dp = new int[2][n+1];
                for(int i1 = 0; i1 < 2; i1++){
                    StringTokenizer st = new StringTokenizer(bf.readLine());
                    for(int j1 = 1; j1 <= n; j1++){
                        arr[i1][j1] = Integer.parseInt(st.nextToken());
                    }
                }
                dp[0][1] = arr[0][1];
                dp[1][1] = arr[1][1];
                if(n > 1){
                    dp[0][2] = dp[1][1] + arr[0][2];
                    dp[1][2] = dp[0][1] + arr[1][2];
                    for(int j = 3; j <= n; j++){
                        dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                        dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
                    }
                }
                int maximum = Math.max(dp[0][n], dp[1][n]);
                if(i == T-1)
                    System.out.print(maximum);
                else
                    System.out.println(maximum);

            }

        }

    }
