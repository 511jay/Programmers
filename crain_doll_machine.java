package jhlee;
import java.util.Stack;

public class crain_doll_machine {
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
				};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
		
	}
    public static int solution(int[][] board, int[] moves) {
    	int point = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(int i=0; i<moves.length; i++) {
    		int j = 0;
    		while(j<board.length) {
    			if(board[j][moves[i]-1] != 0) {
    				if (stack.isEmpty() == false && stack.peek() == board[j][moves[i]-1]) {
    					stack.pop();
    					point+=2;
    					board[j][moves[i]-1] = 0;
    				}else {
    					stack.push(board[j][moves[i]-1]);
        				board[j][moves[i]-1] = 0;
    				}
    				break;
    			}
    			j++;
    		}
    	}
    	return point;
    }
    
}
