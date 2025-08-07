import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] suma;
    static int size, num;
    static int startx, starty, endx, endy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        board = new int[size+1][size+1];
        for(int i = 1; i <= size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= size; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        suma = new int[size+1][size+1];
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                suma[i][j] = board[i][j] + suma[i][j-1] + suma[i-1][j] - suma[i-1][j-1];
            }
        }
        int sum;
        for(int i = 0; i < num ; i++){
            sum = 0;
            st = new StringTokenizer(br.readLine());
            startx = Integer.parseInt(st.nextToken());
            starty = Integer.parseInt(  st.nextToken());
            endx = Integer.parseInt(st.nextToken());
            endy = Integer.parseInt(st.nextToken());
            sum = suma[endx][endy] - suma[startx-1][endy] - suma[endx][starty-1] + suma[startx-1][starty-1];
            if(i == num-1){
                System.out.print(sum);
            }
            else{
                System.out.println(sum);
            }
        }
    }
}
