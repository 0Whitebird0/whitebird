#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int n;
int dp[1001][3];
int cost[1001][3];

int mini(int a, int b) {
	if (a > b)
		return b;
	return a;
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			scanf("%d", &cost[i][j]);
			if (i == 0) {
				dp[i][j] = cost[i][j];
			}
		}
	}
	
	for (int i = 1; i < n; i++) {
		dp[i][0] = mini(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
		dp[i][1] = mini(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
		dp[i][2] = mini(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
	}
	printf("%d", mini(mini(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
}
