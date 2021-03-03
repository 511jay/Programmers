package day2021_01;
import java.util.ArrayList;

class Solution {
    static int[][] map;
	static boolean[][] visit;
	static int max_row;
	static int max_col;
	static int min_budget;
    public int solution(int[][] board) {
        map = board;
		min_budget = 0;
		visit = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				visit[i][j] = false;
			}
		}
		max_row = map.length-1;
		max_col = map[0].length-1;
		String str = "0";
		dfs(0, 0, str);
		return min_budget;
    }
    static void dfs(int row, int col, String way) {
		if(row == max_row && col == max_col) {
			if(min_budget == 0) {
				min_budget = way_budget(way);
			}else if(way_budget(way)<min_budget){
				min_budget = way_budget(way);
			}
			return;
		}
		int r = 0;
		int c = 0;
		visit[r][c] = true;
		for(int i=0; i<way.length(); i++) {
			switch (Character.getNumericValue(way.charAt(i))) {
			case 1:
				c--;
				break;
			case 2:
				c++;
				break;
			case 3:
				r--;
				break;
			case 4:
				r++;
				break;
			default:
				break;
			}
			visit[r][c] = true;
		}
		ArrayList<Integer> next = new ArrayList<Integer>();
		if(Left(row, col))
			next.add(1);
		if(Right(row, col))
			next.add(2);
		if(Down(row, col))
			next.add(4);
		if(Up(row, col))
			next.add(3);
		visit_clear();
		
		
		for(int i=0; i<next.size(); i++) {
			int next_row = row;
			int next_col = col;
			String temp_str = way+next.get(i);
			switch (next.get(i)) {
			case 1:
				next_col--;
				break;
			case 2:
				next_col++;
				break;
			case 3:
				next_row--;
				break;
			case 4:
				next_row++;
				break;
			}
			dfs(next_row, next_col, temp_str);
		}
	}
	static boolean Left(int row, int col) {
		if(col-1<0)
			return false;
		else if(map[row][col-1] == 1 || visit[row][col-1] == true)
			return false;
		return true;
	}
	static boolean Right(int row, int col) {
		if(col+1>=map[0].length)
			return false;
		else if(map[row][col+1] == 1 || visit[row][col+1] == true)
			return false;
		return true;
	}
	static boolean Up(int row, int col) {
		if(row-1<0)
			return false;
		else if(map[row-1][col] == 1 || visit[row-1][col] == true)
			return false;
		return true;
	}
	static boolean Down(int row, int col) {
		if(row+1>=map.length)
			return false;
		else if(map[row+1][col] == 1 || visit[row+1][col] == true)
			return false;
		return true;
	}
	
	static void visit_clear() {
		for(int i=0; i<max_row+1; i++) {
			for(int j=0; j<max_col+1; j++) {
				visit[i][j] = false;
			}
		}
	}
	static int way_budget(String str) {
		int before = 0;
		int sum = (str.length()-1)*100;
		for(int i=1; i<str.length(); i++) {
			switch (Character.getNumericValue(str.charAt(i))) {
			case 1: 
				if(before == 3 || before == 4)
					sum+=500;
				break;
			case 2: 
				if(before == 3 || before == 4)
					sum+=500;
				break;
			case 3: 
				if(before == 1 || before == 2)
					sum+=500;
				break;
			case 4: 
				if(before == 1 || before == 2)
					sum+=500;
				break;
			default:
				break;
			}
			before = Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}

}
