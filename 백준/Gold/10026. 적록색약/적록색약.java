import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static Queue<node> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class node{
        int y, x;
        node (int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int color = 0;
        int non_color = 0;
        int cury = 0, curx = 0;
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                if(!visited[j][k]){
                    cury = j;
                    curx = k;
                    color++;
                }
                q.add(new node(cury, curx));
                while(!q.isEmpty()) {
                    node p = q.poll();
                    visited[p.y][p.x] = true;
                    char c = grid[p.y][p.x];
                    for (int i = 0; i < 4; i++) {
                        int y = p.y + dy[i];
                        int x = p.x + dx[i];
                        if (0 <= y && y < n && 0 <= x && x < n) {
                            if (!visited[y][x] && c == grid[y][x]) {
                                q.add(new node(y, x));
                                visited[y][x] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                if(!visited[j][k]){
                    cury = j;
                    curx = k;
                    non_color++;
                }
                q.add(new node(cury, curx));
                while(!q.isEmpty()) {
                    node p = q.poll();
                    visited[p.y][p.x] = true;
                    char c = grid[p.y][p.x];
                    for (int i = 0; i < 4; i++) {
                        int y = p.y + dy[i];
                        int x = p.x + dx[i];
                        if (0 <= y && y < n && 0 <= x && x < n) {
                            if (!visited[y][x]) {
                                if(c == 'R'){
                                    if(grid[y][x] == 'R' || grid[y][x] == 'G'){
                                        q.add(new node(y, x));
                                        visited[y][x] = true;
                                    }
                                }
                                else if(c == 'G'){
                                    if(grid[y][x] == 'R' || grid[y][x] == 'G'){
                                        q.add(new node(y, x));
                                        visited[y][x] = true;
                                    }
                                }
                                else{
                                    if(grid[y][x] == 'B'){
                                        q.add(new node(y, x));
                                        visited[y][x] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(color + " " + non_color);
    }

}
