import java.io.*;
import java.util.Arrays;

public class Main {
    static int cnt = 0;
    static int r;
    static int c;
    static int flag = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        r = Integer.parseInt(tokens[1]);
        c = Integer.parseInt(tokens[2]);

        int pown = power(n);
        int starty = 0;
        int startx = 0;
        scan(pown, starty, startx, r, c);

        bw.flush();
        bw.close();
        br.close();
    }
    public static int power(int n) {
        if(n == 1) return 2;
        return power(n - 1)*2;
    }
    public static void scan(int pown, int starty, int startx, int r, int c) {
        if(flag == 1){
            return;
        }
        if(pown == 2) {
            cnt++;
            if(startx == c && starty == r){
                flag = 1;
                System.out.print(cnt-1);
                return;
            }
            cnt++;
            if(startx+1 == c && starty == r){
                flag = 1;
                System.out.print(cnt-1);
                return;
            }
            cnt++;
            if(startx == c && starty+1 == r){
                flag = 1;
                System.out.print(cnt-1);
                return;
            }
            cnt++;
            if(startx+1 == c && starty+1 == r){
                flag = 1;
                System.out.print(cnt-1);
                return;
            }
            return;
        }
        pown/=2;
        if(startx+pown > c && starty+pown > r){
            cnt+=0;
            scan(pown, starty, startx, r, c);
        }
        else if(startx+pown <= c && starty+pown > r){
            cnt+=pown*pown;
            scan(pown, starty, startx + pown, r, c);
        }
        else if(startx+pown > c && starty+pown <= r){
            cnt+=pown*pown*2;
            scan(pown, starty+pown, startx, r, c);
        }
        else{
            cnt+=pown*pown*3;
            scan(pown, starty+pown, startx+pown, r, c);
        }
    }
}
