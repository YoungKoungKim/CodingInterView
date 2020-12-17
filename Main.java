import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
	static fish[] list;
	static int[][] map;
	static fish shark;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new fish[17];
		map = new int[4][4];
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 8; j+=2) {
				map[i][j/2] = Integer.parseInt(str[j]);
				list[Integer.parseInt(str[j])] = new fish(i, j/2, Integer.parseInt(str[j+1]), Integer.parseInt(str[j]));
			}
		}
		
		shark = new fish(0, 0, list[map[0][0]].dir, list[map[0][0]].num);
		map[0][0] = -1;
		moveAndEat(map, list, shark.num, shark);
		
		System.out.println(max);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
//		for (int i = 1; i < 17; i++) {
//			System.out.println(list[i].toString());
//		}
		
		
	}
	
	public static void moveAndEat(int[][] map, fish[] list, int eat, fish shark) {
		int[][] tmpMap = map;
		for(int k=0; k<4; k++) {
            System.arraycopy(map[k], 0, tmpMap[k], 0, 4);
        }
		
		fish[] tmpList = new fish[17];
		for (int i = 1; i < 17; i++) {
			tmpList[i] = new fish(list[i].x, list[i].y, list[i].dir, list[i].num);
		}
		
		//물고기 이동
		fish moveFish;
		for (int i = 1; i < 17; i++) {
			if (i != shark.num) {
			moveFish = tmpList[i];
				for (int j = 0; j < 8; j++) {
					int nextX = moveFish.x + dx[(moveFish.dir + j) % 8];
					int nextY = moveFish.y + dy[(moveFish.dir + j) % 8];
					if (nextX >= 0 && nextX < 4 && nextY >= 0 && nextY < 4) {
						if (tmpMap[nextX][nextY] != -1) {
							int tmp = tmpMap[nextX][nextY];
							tmpMap[nextX][nextY] = tmpMap[moveFish.x][moveFish.y];
							tmpMap[moveFish.x][moveFish.y] = tmp;
							
							tmpList[tmp].x = moveFish.x;
							tmpList[tmp].y = moveFish.y;
							tmpList[i].x = nextX;
							tmpList[i].y = nextY;
							tmpList[i].dir = (moveFish.dir + j) % 8;
							break;
						}
					}
				}
			}
		}
		
		//상어 이동
		for (int i = 1; i < 4; i++) {
			int nextX = shark.x + dx[shark.dir]*i;
			int nextY = shark.y + dy[shark.dir]*i;
			if (nextX >= 0 && nextX < 4 && nextY >= 0 && nextY < 4) {
				int t = tmpMap[nextX][nextY];
				if (tmpMap[nextX][nextY] > 0) {
					shark.num += t;
					shark.x = nextX;
					shark.y = nextY;
					shark.dir = tmpList[t].dir;
					fish f = new fish(nextX, nextY, list[t].dir, list[t].num);
					
					moveAndEat(tmpMap, tmpList, eat+tmpMap[nextX][nextY], shark);
					
					tmpMap[nextX][nextY] = t;
					tmpList[t] = new fish(nextX, nextY, f.dir, f.num);
					tmpMap[shark.x][shark.y] = -1;
				}
			}
		}
		
		if (max <= eat) {
			max = eat;
		}
	}
}

class fish {
	int x;
	int y;
	int dir;
	int num;
	
	fish(int x, int y, int dir, int num) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.num = num;
	}
	
	fish(int dir, int num) {
		this.dir = dir;
		this.num = num;
	}

	@Override
	public String toString() {
		return "fish [x=" + x + ", y=" + y + ", dir=" + dir + ", num=" + num + "]";
	}
	
}