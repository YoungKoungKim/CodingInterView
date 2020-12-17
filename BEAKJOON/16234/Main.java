import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<country> list;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int sum;
	static int cnt;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<>();
						dfs(i, j);
						
						//인구이동
						if (list.size() > 0 && list != null) {
							cnt++;
							int people = sum / list.size();
							for (country c : list) {
								map[c.x][c.y] = people;
							}
						}
						sum = 0;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = false;
				}
			}
			
			if (cnt > 0) result++;
			else break;
			
			cnt = 0;
		}
		System.out.println(result);
	}
	
	public static void dfs(int x, int y) {
		int nextX;
		int nextY;
		
		for (int i = 0; i < 4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];
			
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if (!visited[nextX][nextY]) {
					if (Math.abs(map[nextX][nextY] - map[x][y]) >= L &&
							Math.abs(map[nextX][nextY] - map[x][y]) <= R) {
						visited[nextX][nextY] = true;
						sum += map[nextX][nextY];
						list.add(new country(nextX, nextY));
						dfs(nextX, nextY);
					}
				}
			}
		}
		
	}
}

class country {
	int x;
	int y;
	
	public country(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
