import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public static int N;
	public static int M;
	public static int start;
	public static int[][] map;
	public static boolean[] visited;
	public static Queue<Integer> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		start = Integer.parseInt(str[2]);
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1];
		Q = new LinkedList<Integer>();
		
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		DFS(start);
		System.out.println();
		
		for (int i = 0; i < N+1; i++) {
			visited[i] = false;
		}
		
		BFS(start);
		System.out.println();
	}
	
	public static void DFS(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i < N+1; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int start) {
		Q.add(start);
		visited[start] = true;
		while (!Q.isEmpty()) {
			int next = Q.poll();
			System.out.print(next + " ");
			for (int i = 1; i < N+1; i++) {
				if (map[next][i] == 1 && !visited[i]) {
					Q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
