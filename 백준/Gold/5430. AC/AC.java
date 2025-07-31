import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            // 배열 파싱
            Deque<Integer> deque = new LinkedList<>();
            arrStr = arrStr.substring(1, arrStr.length() - 1); // [] 제거
            if (n > 0) {
                String[] arr = arrStr.split(",");
                for (String s : arr) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reverse) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
