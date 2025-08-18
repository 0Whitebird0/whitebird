    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.*;

    public class Main {
        static int r, c;
        static int[][] arr;
        static boolean[] alpha;
        static int max;
        static int cnt;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new int[r][c];
            alpha = new boolean[26];
            for (int i = 0; i < r; i++) {
                String str = bf.readLine();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = str.charAt(j) - 'A';
                }
            }
            cnt = 1;
            max = 1;
            alpha[arr[0][0]] = true;
            dfs(0, 0, cnt);
            System.out.println(max);
        }

        public static void dfs(int row, int col, int cnt) {
            max = Math.max(max, cnt);

            // 4방향 탐색
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {
                int nr = row + dx[d];
                int nc = col + dy[d];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c && !alpha[arr[nr][nc]]) {
                    alpha[arr[nr][nc]] = true;
                    dfs(nr, nc, cnt + 1);
                    alpha[arr[nr][nc]] = false;
                }
            }
        }

    }
