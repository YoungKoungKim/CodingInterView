public class Main {
	public static int N;
	public static int[][] map;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		
		
	}
}

class Dot {
	int x;
	int y;
	
	public Dot (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static int N;
	public static int[][] map;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static boolean[][] visited;
	public static babyShark baby;
	public static int sec = 0;
	public static Queue<Dot> q = new LinkedList<>();
	public static List<Dot> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 9) {
					baby = new babyShark(i, j);
				}
			}
		}
		
		boolean result = false;
		while (!result) {
			result = eating(baby.x, baby.y);
			
			Collections.sort(list);
			Dot eatDot = list.get(0);
			sec = sec + eatDot.distance;
			System.out.println(eatDot.distance);
			System.out.println(eatDot.x + ", " + eatDot.y);
			System.out.println();
			//¸Ô°í »ó¾î ¿Å±â±â
			map[baby.x][baby.y] = 0;
			map[eatDot.x][eatDot.y] = 9;
			baby.x = eatDot.x;
			baby.y = eatDot.y;
			baby.eat++;
			
			list.clear();
			reset();
			q.clear();
			
			if (baby.eat == baby.size) {
				baby.size++;
				baby.eat = 0;
			}
			System.out.println("size" + baby.size);
		}
		
		System.out.println(sec);
	}
	
	public static boolean eating(int startX, int startY) {
		q.add(new Dot(startX, startY, 0));
		visited[startX][startY] = true;
		
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			
			int nextX;
			int nextY;
			
			for (int i = 0; i < 4; i++) {
				int nextDistance = dot.distance + 1;
				nextX = dot.x + dx[i];
				nextY = dot.y + dy[i];
				
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (map[nextX][nextY] < baby.size && map[nextX][nextY] != 0) {
						list.add(new Dot(nextX, nextY, nextDistance));
						System.out.println("add list : " + nextX + ", " + nextY);
					} else if (!visited[nextX][nextY] && map[nextX][nextY] == 0 || map[nextX][nextY] == baby.size) {
						q.add(new Dot(nextX, nextY, nextDistance));
						System.out.println("add : " + nextX + ", " + nextY);
						visited[nextX][nextY] = true;
					}
				}
				
				if (!list.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
}

class Dot implements Comparable<Dot> {
	int x;
	int y;
	int distance;
	
	public Dot(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Dot o) {
		if (this.x < o.x) {
			return -1;
		} else if (this.x > o.x) {
			return 1;
		} else {
			if (this.y < o.y) {
				return -1;
			} else if (this.y > o.y) {
				return 1;
			}
		}
		return 0;
	}
}

class babyShark {
	int x;
	int y;
	int size = 2;
	int eat = 0;
	
	public babyShark(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
*/
