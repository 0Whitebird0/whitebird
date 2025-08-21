import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] weight, value, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N =  Integer.parseInt(st.nextToken());
        K =  Integer.parseInt(st.nextToken());

        weight = new int[N];
        value = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K+1];
        for(int i = 0; i < N; i++) {
            for(int j = K; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
