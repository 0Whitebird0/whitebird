import java.util.Scanner;

public class Main {
    static int[][] data;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paper_size = scanner.nextInt();
        data = new int[paper_size + 1][paper_size + 1];

        for (int i = 1; i <= paper_size; i++) {
            for (int j = 1; j <= paper_size; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        scan_paper(1, 1, paper_size, paper_size);
        System.out.println(white);
        System.out.println(blue);
    }

    static void scan_paper(int start_x, int start_y, int end_x, int end_y) {
        if (start_x == end_x && start_y == end_y) {
            if (data[start_x][start_y] == 0) white++;
            else blue++;
            return;
        }

        if (check(start_x, start_y, end_x, end_y)) {
            if (data[start_x][start_y] == 0) white++;
            else blue++;
            return;
        }

        int mid_x = (start_x + end_x) / 2;
        int mid_y = (start_y + end_y) / 2;

        scan_paper(start_x, start_y, mid_x, mid_y);
        scan_paper(start_x, mid_y + 1, mid_x, end_y);
        scan_paper(mid_x + 1, start_y, end_x, mid_y);
        scan_paper(mid_x + 1, mid_y + 1, end_x, end_y);
    }

    static boolean check(int start_x, int start_y, int end_x, int end_y) {
        int color = data[start_x][start_y];
        for (int i = start_x; i <= end_x; i++) {
            for (int j = start_y; j <= end_y; j++) {
                if (data[i][j] != color) return false;
            }
        }
        return true;
    }
}
