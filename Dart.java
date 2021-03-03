package jhlee_java;

import java.util.Stack;



public class Dart {
	public static void main(String[] args) {
		String str1 = "1S2D*3T";
		String str2 = "1D2S#10S";
		String str3 = "1D2S0T";
		String str4 = "1S*2T*3S";
		String str5 = "1D#2S*3S";
		String str6 = "1T2D3D#";
		String str7 = "1D2S3T*";
		System.out.println(solution(str1));
		System.out.println(solution(str2));
		System.out.println(solution(str3));
		System.out.println(solution(str4));
		System.out.println(solution(str5));
		System.out.println(solution(str6));
		System.out.println(solution(str7));
	}

	public static int solution(String dart) {
		Stack<Integer> stack = new Stack<Integer>();
		String str = "";
		for(int i=0; i<dart.length(); i++) {
			if(dart.charAt(i)>47 && dart.charAt(i)<58) {
				if(dart.charAt(i+1)>47 && dart.charAt(i+1)<58) {
					str+=dart.charAt(i);
					continue;
				}else {
					str+=dart.charAt(i);
					stack.push(Integer.parseInt(str));
					str = "";
				}
			}else if(dart.charAt(i)==68 || dart.charAt(i)==83 || dart.charAt(i)==84) {
				int temp = stack.pop();
				switch (dart.charAt(i)) {
				case 68:
					temp = temp*temp;
					break;
				case 84:
					temp = temp*temp*temp;
					break;
				default:
					break;
				}
				stack.push(temp);
			}else if(dart.charAt(i)==35 || dart.charAt(i)==42) {
				if(dart.charAt(i)==42) {
					Stack<Integer> temp_stack = new Stack<Integer>();
					int size = stack.size();
					if(size>2)
						size = 2;
					for(int j=0; j<size; j++) {
						temp_stack.push(stack.pop()*2);
					}
					int temp_size = temp_stack.size();
					for(int j=0; j<temp_size; j++) {
						stack.push(temp_stack.pop());
					}
				}else if(dart.charAt(i)==35) {
					int temp = stack.pop();
					stack.push(-temp);
				}
			}
		}

		int answer = 0;
		int size = stack.size();
		for(int k=0; k<size; k++) {
			answer += stack.pop();
		}
		return answer;
	}
}
