package day2021_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class jewel_shopping2 {
	static HashMap<String, Integer> hash = new HashMap<String, Integer>();
	public static void main(String[] args) {
		String[] in_str = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = Algo(in_str);
		System.out.println(answer[0]+" "+answer[1]);
		
	}
	static int[] Algo(String[] str) {
		arr2List arr2 = new arr2List();
		int max_jewel = jewel_num(str);
		for(int i=0; i<str.length; i++) {
			if(!hash.containsKey(str[i])) {
				hash.put(str[i], i);
			}
			else {
				hash.replace(str[i], i);
			}
			if(hash.size() == max_jewel) {
				int[] LR = buy_lenght(str);
				arr2.arr2add(LR[0], LR[1]);
			}
		}
		return arr2.findMin();
	}
	static int jewel_num(String[] str) {
		int result = 0;
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<str.length; i++) {//n2 
			if(list.contains(str[i])) {
				continue;
			}else {
				list.add(str[i]);	
				result++;
			}
		}
		return result;
	}
	static int[] buy_lenght(String[] str) {
		Collection<Integer> collections= hash.values();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(Integer collection : collections) {
			temp.add(collection);
		}
		int min = str.length; 
		int max = 0;
		for(int i=0; i<temp.size(); i++) {
			if(min>temp.get(i)) {
				min = temp.get(i);
			}
			if(max<temp.get(i)) {
				max = temp.get(i);
			}
		}
		int[] arr = {min, max};
		return arr;
	}
	public static class arr2List {
		ArrayList<Integer> min;
		ArrayList<Integer> max;
		arr2List(){
			min = new ArrayList<Integer>();
			max = new ArrayList<Integer>();
		}
		public void arr2add(int min, int max) {
			this.min.add(min);
			this.max.add(max);
		}
		public int[] findMin() {
			int L = min.get(0);
			int R = max.get(0);
			int R_L = R-L;
			for(int i=1; i<min.size(); i++) {
				if(R_L>(max.get(i)-min.get(i))) {
					L = min.get(i);
					R = max.get(i);
					R_L = R-L;
				}
			}
			int[] result = {L, R};
			return result;
		}
	}
}
