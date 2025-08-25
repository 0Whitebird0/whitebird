import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            if(N==1){
                sum++;
                break;
            }
            dfs(0, i);
            minus(0, i);
        }
        System.out.println(sum);
    }

    public static void dfs(int row, int col){
        plus(row, col);
        for(int i = 0; i < N; i++){
            if(board[row+1][i] == 0){
                if(row+1 == N-1){
                    sum++;
                }
                else{
                    dfs(row+1, i);
                    minus(row+1, i);
                }
            }
        }
        //그 전에 둘수 있는지 반복문으로 확인 후 못두면 return하고 dfs다음에 minus함수 넣어주기
        //선언이 되면 plus함수 넣어주기
        //마지막 줄에 도달하면 0 개수 세서 sum에 더해주기
    }
    public static void plus(int row, int col){
        for(int i = 0; i < N; i++){
            board[i][col]++;
        }

        for(int i = 1; i < N; i++){
            if(row+i < N && 0<= col-i){
                board[row+i][col-i]++;
            }
            if(row+i < N && col+i < N){
                board[row+i][col+i]++;
            }
        }
    }
    public static void minus(int row, int col){
        for(int i = 0; i < N; i++){
            board[i][col]--;
        }
        for(int i = 1; i < N; i++){
            if(row+i < N && 0<= col-i){
                board[row+i][col-i]--;
            }
            if(row+i < N && col+i < N){
                board[row+i][col+i]--;
            }
        }
    }
}
