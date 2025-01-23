#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int dp[10001];
int drink[10001];
int n;

int maxi(int a, int b) {
	if (a > b)
		return a;
	return b;
}
int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &drink[i]);
	}
	dp[0] = 0;
	dp[1] = drink[1];
	dp[2] = drink[1] + drink[2];
	for (int i = 3; i <= n; i++) {
		dp[i] = maxi(maxi(dp[i - 3] + drink[i - 1], dp[i - 2]) + drink[i], dp[i-1]);
	}
	printf("%d", dp[n]);
}
