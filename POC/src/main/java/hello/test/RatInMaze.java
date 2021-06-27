public class RatInMaze {

	
	public static void main(String[] args) {
		RatInMaze obj = new RatInMaze();
				
		byte[][] maze = new byte[][] {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
		
		System.out.println(obj.isPathPossible(maze, 0, 0, 3, 3, 3, 3));
	}
	public boolean isPathPossible(byte[][] maze, int startI, int startJ, int endI, int endJ, int N, int M) {

		if (startI < 0 || startI > N || startJ < 0 || startJ > M) {
			return false;
		}

		if (endI < 0 || endI > N || endJ < 0 || endJ > M) {
			return false;
		}

		if (startI == endI && startJ == endJ) {
			return true;
		}

		if ((startI + 1) <=N && maze[startI + 1][startJ] == 1) {
			if(isPathPossible(maze, startI+1,startJ,endI,endJ,N,M)) return true;
		}
		if (startJ + 1 <=M && maze[startI][startJ+1] == 1) {
			if(isPathPossible(maze, startI,startJ+1,endI,endJ,N,M)) return true;
		}
		if (startI-1>=0 && maze[startI - 1][startJ] == 1) {
			if(isPathPossible(maze, startI-1,startJ,endI,endJ,N,M)) return true;
		}
		
		if (startJ-1>0 && maze[startI][startJ-1] == 1) {
			if(isPathPossible(maze, startI,startJ-1,endI,endJ,N,M)) return true;
		}
		return false;
	}
}
