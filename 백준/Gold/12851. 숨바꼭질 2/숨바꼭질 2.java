    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.*;

    public class Main {
        static int n, k;
        static int[] min_depth;
        static Queue <point> q = new LinkedList<>();

        public static class point{
            int x;
            int depth;
            point(int x,int depth){
                this.x=x;
                this.depth=depth;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            min_depth = new int[100001];
            q.offer(new point(n, 0));
            for(int i = 0; i < 100001; i++){
                min_depth[i] = Integer.MAX_VALUE;
            }
            int result = 0;
            int first_time = 0;
            int min_arrive = 0;
            while(!q.isEmpty()){
                point currentq = q.poll();
                int current_depth = currentq.depth;
                int current_x = currentq.x;
                if(current_x == k){
                    if(first_time == 0){
                        first_time++;
                        min_arrive = current_depth;
                    }
                    result++;
                    current_x = -1;
                }
                if(0 <= current_x && current_x <= 100000){
                    if(current_x - 1 >=0 && current_depth <= min_depth[current_x - 1]){
                        min_depth[current_x - 1] = current_depth;
                        q.offer(new point(current_x-1, current_depth + 1));
                    }
                    if(current_x + 1 <= 100000 && current_depth <= min_depth[current_x + 1]){
                        min_depth[current_x + 1] = current_depth;
                        q.offer(new point(current_x+1, current_depth + 1));
                    }
                    if(current_x * 2 <= 100000 && current_depth <= min_depth[current_x * 2]){
                        min_depth[current_x * 2] = current_depth;
                        q.offer(new point(current_x * 2, current_depth + 1));
                    }
                }

            }
            System.out.println(min_arrive);
            System.out.print(result);
        }


    }
