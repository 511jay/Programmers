package jhlee_java;

public class secret_map {
	public static void main(String[] args) {
		int n = 6;
		int[] map1 = {46, 33, 33, 22, 31, 50};
		int[] map2 = {27, 56, 19, 14, 14, 10};
		
		String[] str = solution(n, map1, map2);
		for(int i=0; i<n; i++) {
			System.out.println(str[i]);
		}
	}
	
	public static String[] solution(int n, int[] map1, int[] map2) {
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			String row = "";
			String row1 = Integer.toBinaryString(map1[i]);
			String row2 = Integer.toBinaryString(map2[i]);
			if(row1.length()<n) {
				while(row1.length()<n) {
					row1 = "0"+row1;
				}
			}
			if(row2.length()<n) {
				while(row2.length()<n) {
					row2 = "0"+row2;
				}
			}
			for(int j=0; j<n; j++) {
				if(row1.charAt(j) == '1' || row2.charAt(j) == '1') {
					row+="#";
				}else {
					row+=" ";
				}
			}
			answer[i] = row;
		}
	    return answer;
	}
}
