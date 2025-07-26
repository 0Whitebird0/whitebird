import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(new Node(n, 1));
        visited.add(n);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            long nextVal1 = (long) current.value * 2;
            if (nextVal1 == m) {
                System.out.println(current.depth + 1);
                return;
            }
            if (nextVal1 < m && !visited.contains((int) nextVal1)) {
                visited.add((int) nextVal1);
                queue.offer(new Node((int) nextVal1, current.depth + 1));
            }
            
            long nextVal2 = (long) current.value * 10 + 1;
            if (nextVal2 == m) {
                System.out.println(current.depth + 1);
                return;
            }
            if (nextVal2 < m && !visited.contains((int) nextVal2)) {
                visited.add((int) nextVal2);
                queue.offer(new Node((int) nextVal2, current.depth + 1));
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int value;
        int depth;
        Node(int v, int d) {
            value = v;
            depth = d;
        }
    }
}

