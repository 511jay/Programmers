package jhlee_java;

public class budget {
	public static void main(String[] args) {
		int money = 10;
		int[] department = {2, 2, 3, 3};
		System.out.println(solution(department, money)); 
	}
	
	public static int solution(int[] D, int money) {
		int[] sorted = D;
		for(int i=1; i<D.length; i++) {
			int temp = D[i];
			for(int j=i-1; j>-1; j--) {
				if(sorted[j]>temp) {
					sorted[j+1] = sorted[j];
					sorted[j] = temp;
				}
			}
		}
		int sum = 0;
		int count = 0;
		for(int i=0; i<sorted.length; i++) {
			if((sum+sorted[i])>money)
				break;
			else {
				sum+=sorted[i];
				count++;
			}
		}
		
		return count;
	}
}
