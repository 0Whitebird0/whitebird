#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int cost[501][501];
int n;

int maxi(int a, int b) {
	if (a > b)
		return a;
	return b;
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i + 1; j++) {
			scanf("%d", &cost[n - i - 1][j]);
		}
	}
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < n-i; j++) {
			cost[i][j] = maxi(cost[i - 1][j], cost[i - 1][j + 1]) + cost[i][j];
		}
	}
	printf("%d", cost[n - 1][0]);
}
