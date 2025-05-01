import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] array1;
    static int[] array2;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        array1 = new int[n];
        array2 = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(input[i]);
        }

        int[] original = array1.clone();
        Arrays.sort(array1);

        array2[cnt++] = array1[0];
        for (int i = 1; i < n; i++) {
            if (array1[i] != array1[i - 1]) {
                array2[cnt++] = array1[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : original) {
            sb.append(search(num)).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int search(int target) {
        int start = 0;
        int end = cnt - 1;

        while (true) {
            int mid = (start + end) / 2;
            if (array2[mid] == target) {
                return mid;
            } else if (array2[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
