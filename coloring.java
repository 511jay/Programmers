package day2021_01_25;

import java.util.Arrays;
import java.util.Scanner;

public class coloring {
	static int[][] map;
	static boolean[][] visit;
	static int max_row;
	static int max_col;
	static int area_num;
	static int[] areas;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		max_row = scan.nextInt();
		max_col = scan.nextInt();
		map = new int[max_row][max_col];
		visit = new boolean[max_row][max_col];
		area_num = 0;
		int max_size = (max_col*max_row)/2;
		areas = new int[max_size];
		
		for(int i=0; i<max_row; i++) {
			for(int j=0; j<max_col; j++) {
				visit[i][j] = false;
				map[i][j] = scan.nextInt();
			}
		}
		
		for(int i=0; i<max_row; i++) {
			for(int j=0; j<max_col; j++) {
				Algo(i, j, 0);
			}
		}
		int result_num = 0;
		for(int i=0; i<max_size; i++) {
			if(areas[i]>0) {
				result_num++;
			}
		}
		Arrays.sort(areas);
		int result_area = areas[areas.length-1];
	}
	
	static void Algo(int row, int col, int n) {
		if(visit[row][col] == true || map[row][col] == 0) {
			return;
		}
		if(visit[row][col] == false && map[row][col]>0 && n == 0) {
			area_num++;
		}
		visit[row][col] = true;
		areas[area_num] += 1;
		if(Left(row, col)) {
			Algo(row, col-1, 1);
		}
		if(Up(row, col)) {
			Algo(row-1, col, 1);
		}
		if(Right(row, col)) {
			Algo(row, col+1, 1);
		}
		if(Down(row, col)) {
			Algo(row+1, col, 1);
		}
	}
	static boolean Left(int row, int col) {
		boolean result = false;
		if((col-1)<0) {
			result = false;
		}else if((map[row][col-1]) == 0) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
	static boolean Up(int row, int col) {
		boolean result = false;
		if((row-1)<0) {
			result = false;
		}else if((map[row-1][col]) == 0) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
	static boolean Right(int row, int col) {
		boolean result = false;
		if((col+1)>(max_col-1)) {
			result = false;
		}else if((map[row][col+1]) == 0) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
	static boolean Down(int row, int col) {
		boolean result = false;
		if((row+1)>(max_row-1)) {
			result = false;
		}else if((map[row+1][col]) == 0) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
}
