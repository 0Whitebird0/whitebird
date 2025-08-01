import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] box;
    static boolean[][] visited;
    static Queue<tomato> queue = new LinkedList<>();
    static int maxdepth = 0;

    static class tomato {
        int y, x, depth;
        tomato(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로(열)
        n = Integer.parseInt(st.nextToken()); // 세로(행)

        box = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new tomato(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            int y = t.y;
            int x = t.x;
            int depth = t.depth;
            maxdepth = Math.max(maxdepth, depth);

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny >= 1 && ny <= n && nx >= 1 && nx <= m) {
                    if (box[ny][nx] == 0 && !visited[ny][nx]) {
                        box[ny][nx] = 1;
                        visited[ny][nx] = true;
                        queue.add(new tomato(ny, nx, depth + 1));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(maxdepth);
    }
}
